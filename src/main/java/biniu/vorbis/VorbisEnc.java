package biniu.vorbis;

/********************************************************************
 *                                                                  *
 * THIS FILE IS PART OF THE OggVorbis SOFTWARE CODEC SOURCE CODE.   *
 * USE, DISTRIBUTION AND REPRODUCTION OF THIS LIBRARY SOURCE IS     *
 * GOVERNED BY A BSD-STYLE SOURCE LICENSE INCLUDED WITH THIS SOURCE *
 * IN 'COPYING'. PLEASE READ THESE TERMS BEFORE DISTRIBUTING.       *
 *                                                                  *
 * THE OggVorbis SOURCE CODE IS (C) COPYRIGHT 1994-2002             *
 * by the XIPHOPHORUS Company http://www.xiph.org/                  *
 *                                                                  *
 ********************************************************************
 * <p>Title: EncoderVorbis</p>
 * <p>Description: Codec for encoding music files (wav -> ogg) </p>
 * @author Zbigniew Sudnik
 * @version 1.1.0j
 * function:
 * last mod: 2005-05-01 07:00:00
 ********************************************************************/

import biniu.vorbis.modes.Psych44;
import biniu.vorbis.modes.Setup11;
import biniu.vorbis.modes.Setup16;
import biniu.vorbis.modes.Setup22;
import biniu.vorbis.modes.Setup32;
import biniu.vorbis.modes.Setup44;
import biniu.vorbis.modes.Setup44u;
import biniu.vorbis.modes.Setup8;
import biniu.vorbis.modes.SetupX;




public class VorbisEnc {

  private CodecSetupInfo ci;
  private Info vi;
  private HighlevelEncodeSetup hi;




  /* a few static coder conventions */
  static InfoMode[] _mode_template={
    new InfoMode(0,0,0,0),
    new InfoMode(1,0,0,1)
  };

  public static VeSetupDataTemplate[] setupList = {
      Setup44.ve_setup_44_stereo,
      Setup44u.ve_setup_44_uncoupled,

      Setup32.ve_setup_32_stereo,
      Setup32.ve_setup_32_uncoupled,

      Setup22.ve_setup_22_stereo,
      Setup22.ve_setup_22_uncoupled,
      Setup16.ve_setup_16_stereo,
      Setup16.ve_setup_16_uncoupled,

      Setup11.ve_setup_11_stereo,
      Setup11.ve_setup_11_uncoupled,
      Setup8.ve_setup_8_stereo,
      Setup8.ve_setup_8_uncoupled,

      SetupX.ve_setup_X_stereo,
      SetupX.ve_setup_X_uncoupled,
      SetupX.ve_setup_XX_stereo,
      SetupX.ve_setup_XX_uncoupled,
      null
  };

  private int setTopLevel(int ch,int rate){
    if(true){//biniu vi.equals(vi.codec_setup)){
      vi.version=0;
      vi.channels=ch;
      vi.rate=rate;
      return(0);
    }
    return(Const.OV_EINVAL);
  }

  private void setFloor(double s,int block, StaticCodeBook[][]  books,
                InfoFloor1[] in, int[] x){

    int i,k,is=(int)s;
    InfoFloor1 f= new InfoFloor1();


    f.setValue( in[ x[is] ]);
    /* fill in the lowpass field, even if it's temporary */
    f.n=ci.blocksizes[block]>>1;

    /* books */
    {
      int partitions=f.partitions;
      int maxclass=-1;
      int maxbook=-1;
      for(i=0;i<partitions;i++)
        if(f.partitionclass[i]>maxclass)maxclass=f.partitionclass[i];
      for(i=0;i<=maxclass;i++){
        if(f.class_book[i]>maxbook)maxbook=f.class_book[i];
        f.class_book[i]+=ci.books;
        for(k=0;k<(1<<f.class_subs[i]);k++){
          if(f.class_subbook[i][k]>maxbook)maxbook=f.class_subbook[i][k];
          if(f.class_subbook[i][k]>=0)f.class_subbook[i][k]+=ci.books;
        }
      }

      for(i=0;i<=maxbook;i++)
        ci.bookParam[ci.books++]=books[x[is]][i];
    }

    /* for now, we're only using floor 1 */
    ci.floorType[ci.floors]=1;
    ci.floorParam[ci.floors]=f;
    ci.floors++;

    return;
  }

  private void setGlobalPsych(double s, InfoPsyGlobal[] in,  double[] x){

    int i,is=(int)s;
    double ds=s-is;

    InfoPsyGlobal g=ci.psyGlobParam;

    g.setValue( in[ (int)x[is] ]);


    ds=x[is]*(1.-ds)+x[is+1]*ds;
    is=(int)ds;
    ds-=is;
    if(ds==0 && is>0){
      is--;
      ds=1.;
    }

    /* interpolate the trigger threshholds */
    for(i=0;i<4;i++){
      g.preecho_thresh[i]=(float)(in[is].preecho_thresh[i]*(1.-ds)+in[is+1].preecho_thresh[i]*ds);
      g.postecho_thresh[i]=(float)(in[is].postecho_thresh[i]*(1.-ds)+in[is+1].postecho_thresh[i]*ds);
    }
    g.ampmax_att_per_sec=(float)ci.hiEncSet.amplitude_track_dBpersec;
    return;
  }

  private void initGlobalStereo( AdjStereo[] p){

    float s=(float)hi.stereo_point_setting;
    int i,is=(int)s;
    double ds=s-is;

    InfoPsyGlobal g=ci.psyGlobParam;

    if(p != null){
      g.coupling_prepointamp=p[is].pre;
      g.coupling_postpointamp=p[is].post;

      if(hi.managed == 1){
        /* interpolate the kHz threshholds */
        for(i=0;i<Const.PACKETBLOBS;i++){
          float kHz=(float)(p[is].kHz[i]*(1.-ds)+p[is+1].kHz[i]*ds);
          g.coupling_pointlimit[0][i]=(int)(kHz*1000./vi.rate*ci.blocksizes[0]);
          g.coupling_pointlimit[1][i]=(int)(kHz*1000./vi.rate*ci.blocksizes[1]);
          g.coupling_pkHz[i]=(int)kHz;

          kHz=(int)(p[is].lowpasskHz[i]*(1.-ds)+p[is+1].lowpasskHz[i]*ds);
          g.sliding_lowpass[0][i]=(int)(kHz*1000./vi.rate*ci.blocksizes[0]);
          g.sliding_lowpass[1][i]=(int)(kHz*1000./vi.rate*ci.blocksizes[1]);

        }
      }else{
        float kHz=(float)(p[is].kHz[Const.PACKETBLOBS/2]*(1.-ds)+p[is+1].kHz[Const.PACKETBLOBS/2]*ds);
        for(i=0;i<Const.PACKETBLOBS;i++){
          g.coupling_pointlimit[0][i]=(int)(kHz*1000./vi.rate*ci.blocksizes[0]);
          g.coupling_pointlimit[1][i]=(int)(kHz*1000./vi.rate*ci.blocksizes[1]);
          g.coupling_pkHz[i]=(int)kHz;
        }

        kHz=(int)(p[is].lowpasskHz[Const.PACKETBLOBS/2]*(1.-ds)+p[is+1].lowpasskHz[Const.PACKETBLOBS/2]*ds);
        for(i=0;i<Const.PACKETBLOBS;i++){
          g.sliding_lowpass[0][i]=(int)(kHz*1000./vi.rate*ci.blocksizes[0]);
          g.sliding_lowpass[1][i]=(int)(kHz*1000./vi.rate*ci.blocksizes[1]);
        }
      }
    }else{
      for(i=0;i<Const.PACKETBLOBS;i++){
        g.sliding_lowpass[0][i]=ci.blocksizes[0];
        g.sliding_lowpass[1][i]=ci.blocksizes[1];
      }
    }
    return;
  }

  private void setPsyset( double s, int[] nn_start,  int[] nn_partition,
                         double[] nn_thresh, int block){

    PsyInfo p=ci.psyParam[block];

    int is=(int)s;

    if(block>=ci.psys)
      ci.psys=block+1;
    if(p != null){
      ci.psyParam[block]=p;
    }

    p.setValues( Psych44._psy_info_template);
    p.blockflag=block>>1;

    if(hi.noise_normalize_p == 1){
      p.normal_channel_p=1;
      p.normal_point_p=1;
      p.normal_start=nn_start[is];
      p.normal_partition=nn_partition[is];
      p.normal_thresh=nn_thresh[is];
    }

    return;
  }

  private void setTonemask(double s,int block, Att3[] att,
                           int[]  max, VpAdjBlock[] in){

    int i,is=(int)s;
    double ds=s-is;
    PsyInfo p=ci.psyParam[block];

    /* 0 and 2 are only used by bitmanagement, but there's no harm to always
       filling the values in here */
    p.tone_masteratt[0]=(float)(att[is].att[0]*(1.-ds)+att[is+1].att[0]*ds);
    p.tone_masteratt[1]=(float)(att[is].att[1]*(1.-ds)+att[is+1].att[1]*ds);
    p.tone_masteratt[2]=(float)(att[is].att[2]*(1.-ds)+att[is+1].att[2]*ds);
    p.tone_centerboost=(float)(att[is].boost*(1.-ds)+att[is+1].boost*ds);
    p.tone_decay=(float)(att[is].decay*(1.-ds)+att[is+1].decay*ds);

    p.max_curve_dB=(float)(max[is]*(1.-ds)+max[is+1]*ds);

    for(i=0;i<Psy.P_BANDS;i++)
      p.toneatt[i]=(float)(in[is].block[i]*(1.-ds)+in[is+1].block[i]*ds);
    return;
  }


  private void setCompandBlock(double s,int block, CompandBlock[] in, double[] x){
    int i,is=(int)s;
    double ds=s-is;

    PsyInfo p=ci.psyParam[block];

    ds=x[is]*(1.-ds)+x[is+1]*ds;
    is=(int)ds;
    ds-=is;
    if(ds==0 && is>0){
      is--;
      ds=1.;
    }

    /* interpolate the compander settings */
    for(i=0;i<Psy.NOISE_COMPAND_LEVELS;i++)
      p.noisecompand[i]=(float)(in[is].data[i]*(1.-ds)+in[is+1].data[i]*ds);
    return;
  }

  private void setPeak(double s,int block, int[] suppress){

    int is=(int)s;
    double ds=s-is;
    PsyInfo p=ci.psyParam[block];

    p.tone_abs_limit=(float)(suppress[is]*(1.-ds)+suppress[is+1]*ds);

    return;
  }

  private void setNoisebias(double s,int block, int[] suppress,
                            Noise3[] in, NoiseGuard[] guard, double userbias){

    int i,is=(int)s,j;
    double ds=s-is;
    PsyInfo p=ci.psyParam[block];

    p.noisemaxsupp=(float)(suppress[is]*(1.-ds)+suppress[is+1]*ds);
    p.noisewindowlomin=guard[block].lo;
    p.noisewindowhimin=guard[block].hi;
    p.noisewindowfixed=guard[block].fixed;

    for(j=0;j<Psy.P_NOISECURVES;j++)
      for(i=0;i<Psy.P_BANDS;i++)
        p.noiseoff[j][i]=(float)(in[is].data[j][i]*(1.-ds)+in[is+1].data[j][i]*ds);

    /* impulse blocks may take a user specified bias to boost the
       nominal/high noise encoding depth */
    for(j=0;j<Psy.P_NOISECURVES;j++){
      float min=p.noiseoff[j][0]+6; /* the lowest it can go */
      for(i=0;i<Psy.P_BANDS;i++){
        p.noiseoff[j][i]+=userbias;
        if(p.noiseoff[j][i]<min)p.noiseoff[j][i]=min;
      }
    }

    return;
  }

  private void setAth(int block){
    PsyInfo p=ci.psyParam[block];

    p.ath_adjatt=(float)(ci.hiEncSet.ath_floating_dB);
    p.ath_maxatt=(float)(ci.hiEncSet.ath_absolute_dB);
    return;
  }


  private int bookDupOrNew(StaticCodeBook book){
    int i;
    for(i=0;i<ci.books;i++)
      if(ci.bookParam[i]==book)return(i);

    return(ci.books++);
  }

  private void setBlocksize(double s,   int[] shortb,int[] longb){

    int is=(int)s;

    int blockshort=shortb[is];
    int blocklong=longb[is];
    ci.blocksizes[0]=blockshort;
    ci.blocksizes[1]=blocklong;

  }

  private void setResidue( int number, int block, VorbisResidueTemplate res){

    int i,n;
    if(ci.residueParam[number] == null) ci.residueParam[number] = new InfoResidue0();
    InfoResidue0 r=(InfoResidue0)ci.residueParam[number];//=_ogg_malloc(sizeof(*r));
    r.setValues( res.res );
    if(ci.residues<=number)ci.residues=number+1;

    switch(ci.blocksizes[block]){
    case 64:case 128:case 256:
      r.grouping=16;
      break;
    default:
      r.grouping=32;
      break;
    }
    ci.residueType[number]=res.res_type;

    /* to be adjusted by lowpass/pointlimit later */
    n=r.end=ci.blocksizes[block]>>1;
    if(res.res_type==2)
      n=r.end*=vi.channels;

    /* fill in all the books */
    {
      int booklist=0,k;

      if (ci.hiEncSet.managed != 0) {
        for (i = 0; i < r.partitions; i++) {
          for (k = 0; k < 3; k++) {
            if (res.books_base_managed[i][k] != null) {
              r.secondstages[i] |= (1 << k);
            }
          }
        }
        r.groupbook = bookDupOrNew( res.book_aux_managed);
        ci.bookParam[r.groupbook] = res.book_aux_managed;
        for (i = 0; i < r.partitions; i++) {
          for (k = 0; k < 3; k++) {
            if (res.books_base_managed[i][k] != null) {
              int bookid = bookDupOrNew( res.books_base_managed[i][k]);
              r.booklist[booklist++] = bookid;
              ci.bookParam[bookid] = res.books_base_managed[i][k];
            }
          }
        }
      } else {
        for (i = 0; i < r.partitions; i++) {
          for (k = 0; k < 3; k++) {
            if (res.books_base[i][k] != null) {
              r.secondstages[i] |= (1 << k);
            }
          }
        }
        r.groupbook = bookDupOrNew( res.book_aux);
        ci.bookParam[r.groupbook] = res.book_aux;
        for (i = 0; i < r.partitions; i++) {
          for (k = 0; k < 3; k++) {
            if (res.books_base_managed[i][k] != null) {
              int bookid = bookDupOrNew( res.books_base[i][k]);
              r.booklist[booklist++] = bookid;
              ci.bookParam[bookid] = res.books_base[i][k];
            }
          }
        }
      }
    }

    /* lowpass setup/pointlimit */
    {
      double freq=ci.hiEncSet.lowpass_kHz*1000.;
      InfoFloor1 f=(InfoFloor1)ci.floorParam[block]; /* by convention */
      double nyq=vi.rate/2.;
      int blocksize=ci.blocksizes[block]>>1;

      /* lowpass needs to be set in the floor and the residue. */
      if(freq>nyq)freq=nyq;
      /* in the floor, the granularity can be very fine; it doesn't alter
         the encoding structure, only the samples used to fit the floor
         approximation */
      f.n=(int)(freq/nyq*blocksize);

      /* this res may by limited by the maximum pointlimit of the mode,
         not the lowpass. the floor is always lowpass limited. */
      if(res.limit_type == 1){
        if(ci.hiEncSet.managed == 1)
          freq=ci.psyGlobParam.coupling_pkHz[Const.PACKETBLOBS-1]*1000.;
        else
          freq=ci.psyGlobParam.coupling_pkHz[Const.PACKETBLOBS/2]*1000.;
        if(freq>nyq)freq=nyq;
      }

      /* in the residue, we're constrained, physically, by partition
         boundaries.  We still lowpass 'wherever', but we have to round up
         here to next boundary, or the vorbis spec will round it *down* to
         previous boundary in encode/decode */
      if(ci.residueType[block]==2)
        r.end=(int)((freq/nyq*blocksize*2)/r.grouping+.9)* /* round up only if we're well past */
          r.grouping;
      else
        r.end=(int)((freq/nyq*blocksize)/r.grouping+.9)* /* round up only if we're well past */
          r.grouping;
    }
  }

  /* we assume two maps in this encoder */
  private void setMapRes(double s, VorbisMappingTemplate[] maps){

    int i,j,is=(int)s;
    int modes=2;
    InfoMapping0[] map=(InfoMapping0[])maps[is].map;
    InfoMode[] mode=_mode_template;
    VorbisResidueTemplate[] res=maps[is].res;

    if(ci.blocksizes[0]==ci.blocksizes[1])modes=1;

    for(i=0;i<modes;i++){

      if(ci.mapParam[i] == null) ci.mapParam[i] = new InfoMapping0();
      if(ci.modeParam[i] == null) ci.modeParam[i] = new InfoMode();

      ci.modeParam[i].setValues( mode[i] );
      if(i>=ci.modes)ci.modes=i+1;

      ci.mapType[i]=0;
      ci.mapParam[i].setValues( map[i] );
      if(i>=ci.maps)ci.maps=i+1;

      for(j=0;j<map[i].submaps;j++)
        setResidue( map[i].residuesubmap[j],i
                    ,res[ map[i].residuesubmap[j] ]);
    }
  }

   private double setApproxBitrate(){

    VeSetupDataTemplate setup=(VeSetupDataTemplate)hi.setup;
    int is=(int)hi.base_setting;
    double ds=hi.base_setting-is;
    int ch=vi.channels;
    double[] r=setup.rate_mapping;

    if(r==null)
      return(-1);

    return((r[is]*(1.-ds)+r[is+1]*ds)*ch);
  }

   private void getSetupTemplate( int ch,int srate,
                                 double req,
                                 int q_or_bitrate){
    int i=0;
    int j;
    if(q_or_bitrate  == 1)req/=ch;

    while(setupList[i] != null){
      if(setupList[i].coupling_restriction==-1 || setupList[i].coupling_restriction==ch){
        if(srate>=setupList[i].samplerate_min_restriction &&
           srate<=setupList[i].samplerate_max_restriction){
          int mappings=setupList[i].mappings;
          double[] map=(q_or_bitrate == 1?
                       setupList[i].rate_mapping:
                       setupList[i].quality_mapping);

          /* the template matches.  Does the requested quality mode
             fall within this template's modes? */
          if(req<map[0]){++i;continue;}
          if(req>map[setupList[i].mappings]){++i;continue;}
          for(j=0;j<mappings;j++)
            if(req>=map[j] && req<map[j+1])break;
          /* an all-points match */
          hi.setup=setupList[i];
          if(j==mappings)
            hi.base_setting=j-.001;
          else{
            float low=(float)map[j];
            float high=(float)map[j+1];
            float del=(float)((req-low)/(high-low));
            hi.base_setting=j+del;
          }

          return;
        }
      }
      i++;
    }

    hi.setup=null;
  }

  /* encoders will need to use vorbis_info_init beforehand and call
     vorbis_info clear when all done */

  /* two interfaces; this, more detailed one, and later a convenience
     layer on top */

  /* the final setup call */
  private int setSetupInit(){
    int i0=0,singleblock=0;
    VeSetupDataTemplate setup=null;

    if(ci==null)return(Const.OV_EINVAL);
    if(hi.impulse_block_p != 1)i0=1;

    /* too low/high an ATH floater is nonsensical, but doesn't break anything */
    if(hi.ath_floating_dB>-80)hi.ath_floating_dB=-80;
    if(hi.ath_floating_dB<-200)hi.ath_floating_dB=-200;

    /* again, bound this to avoid the app shooting itself int he foot
       too badly */
    if(hi.amplitude_track_dBpersec>0.)hi.amplitude_track_dBpersec=0.;
    if(hi.amplitude_track_dBpersec<-99999.)hi.amplitude_track_dBpersec=-99999.;

    /* get the appropriate setup template; matches the fetch in previous
       stages */
    setup=(VeSetupDataTemplate )hi.setup;
    if(setup==null)return(Const.OV_EINVAL);

    hi.set_in_stone=1;
    /* choose block sizes from configured sizes as well as paying
       attention to long_block_p and short_block_p.  If the configured
       short and long blocks are the same length, we set long_block_p
       and unset short_block_p */
    setBlocksize(hi.base_setting,
                                  setup.blocksize_short,
                                  setup.blocksize_long);
    if(ci.blocksizes[0]==ci.blocksizes[1])singleblock=1;

    /* floor setup; choose proper floor params.  Allocated on the floor
       stack in order; if we alloc only long floor, it's 0 */
    setFloor(hi.short_setting,0,
                              setup.floor_books,
                              setup.floor_params,
                              setup.floor_short_mapping);
    if(singleblock != 1)
      setFloor(hi.long_setting,1, setup.floor_books,setup.floor_params,
                                setup.floor_long_mapping);

    /* setup of [mostly] short block detection and stereo*/
    setGlobalPsych(hi.trigger_setting, setup.global_params, setup.global_mapping);
    initGlobalStereo( setup.stereo_modes );

    /* basic psych setup and noise normalization */
    setPsyset(hi.short_setting,
              setup.psy_noise_normal_start[0],
              setup.psy_noise_normal_partition[0],
              setup.psy_noise_normal_thresh,
              0);
    setPsyset(hi.short_setting,
              setup.psy_noise_normal_start[0],
              setup.psy_noise_normal_partition[0],
              setup.psy_noise_normal_thresh,
              1);
    if(singleblock != 1){
      setPsyset(hi.long_setting,
                setup.psy_noise_normal_start[1],
                setup.psy_noise_normal_partition[1],
                setup.psy_noise_normal_thresh,
                2);
      setPsyset(hi.long_setting,
                setup.psy_noise_normal_start[1],
                setup.psy_noise_normal_partition[1],
                setup.psy_noise_normal_thresh,
                3);
    }

    /* tone masking setup */
    setTonemask(hi.block[i0].tone_mask_setting,0,
                setup.psy_tone_masteratt,
                setup.psy_tone_0dB,
                setup.psy_tone_adj_impulse);
    setTonemask(hi.block[1].tone_mask_setting,1,
                setup.psy_tone_masteratt,
                setup.psy_tone_0dB,
                setup.psy_tone_adj_other);
    if(singleblock  != 1){
      setTonemask(hi.block[2].tone_mask_setting,2,
                  setup.psy_tone_masteratt,
                  setup.psy_tone_0dB,
                  setup.psy_tone_adj_other);
      setTonemask(hi.block[3].tone_mask_setting,3,
                  setup.psy_tone_masteratt,
                  setup.psy_tone_0dB,
                  setup.psy_tone_adj_long);
    }

    /* noise companding setup */
    setCompandBlock(hi.block[i0].noise_compand_setting,0,
                    setup.psy_noise_compand,
                    setup.psy_noise_compand_short_mapping);
    setCompandBlock(hi.block[1].noise_compand_setting,1,
                    setup.psy_noise_compand,
                    setup.psy_noise_compand_short_mapping);
    if(singleblock != 1){
      setCompandBlock(hi.block[2].noise_compand_setting,2,
                      setup.psy_noise_compand,
                      setup.psy_noise_compand_long_mapping);
      setCompandBlock(hi.block[3].noise_compand_setting,3,
                      setup.psy_noise_compand,
                      setup.psy_noise_compand_long_mapping);
    }

    /* peak guarding setup  */
    setPeak(hi.block[i0].tone_peaklimit_setting,0,
            setup.psy_tone_dBsuppress);
    setPeak(hi.block[1].tone_peaklimit_setting,1,
            setup.psy_tone_dBsuppress);
    if(singleblock != 1){
      setPeak(hi.block[2].tone_peaklimit_setting,2,
              setup.psy_tone_dBsuppress);
      setPeak(hi.block[3].tone_peaklimit_setting,3,
              setup.psy_tone_dBsuppress);
    }

    /* noise bias setup */
    setNoisebias(hi.block[i0].noise_bias_setting,0,
                 setup.psy_noise_dBsuppress,
                 setup.psy_noise_bias_impulse,
                 setup.psy_noiseguards,
                 (i0==0?hi.impulse_noisetune:0.));
    setNoisebias(hi.block[1].noise_bias_setting,1,
                 setup.psy_noise_dBsuppress,
                 setup.psy_noise_bias_padding,
                 setup.psy_noiseguards,0.);
    if(singleblock != 1){
      setNoisebias(hi.block[2].noise_bias_setting,2,
                   setup.psy_noise_dBsuppress,
                   setup.psy_noise_bias_trans,
                   setup.psy_noiseguards,0.);
      setNoisebias(hi.block[3].noise_bias_setting,3,
                   setup.psy_noise_dBsuppress,
                   setup.psy_noise_bias_long,
                   setup.psy_noiseguards,0.);
    }

    setAth(0);
    setAth(1);
    if(singleblock != 1){
      setAth(2);
      setAth(3);
    }

    setMapRes(hi.base_setting,setup.maps);

    /* set bitrate readonlies and management */
    if(hi.bitrate_av>0)
      vi.bitrate_nominal=hi.bitrate_av;
    else{
      vi.bitrate_nominal=(int)setApproxBitrate();
    }

    vi.bitrate_lower=hi.bitrate_min;
    vi.bitrate_upper=hi.bitrate_max;
    if(hi.bitrate_av != 0)
      vi.bitrate_window=(int)((double)hi.bitrate_reservoir/hi.bitrate_av);
    else
      vi.bitrate_window=(int)0.;

    if(hi.managed != 0){
      ci.biManInfo.avg_rate=hi.bitrate_av;
      ci.biManInfo.min_rate=hi.bitrate_min;
      ci.biManInfo.max_rate=hi.bitrate_max;

      ci.biManInfo.reservoir_bits=hi.bitrate_reservoir;
      ci.biManInfo.reservoir_bias=
        hi.bitrate_reservoir_bias;

      ci.biManInfo.slew_damp=hi.bitrate_av_damp;

    }

    return(0);

  }

  private int setupSettingo(  int  channels,   int  rate){

    int ret=0,i,is;
    VeSetupDataTemplate setup=(VeSetupDataTemplate)hi.setup;
    double ds;

    ret=setTopLevel(channels,rate);
    if(ret==1)return(ret);

    is=(int)hi.base_setting;
    ds=hi.base_setting-is;

    hi.short_setting=hi.base_setting;
    hi.long_setting=hi.base_setting;

    hi.managed=0;

    hi.impulse_block_p=1;
    hi.noise_normalize_p=1;

    hi.stereo_point_setting=hi.base_setting;
    hi.lowpass_kHz=
      setup.psy_lowpass[is]*(1.-ds)+setup.psy_lowpass[is+1]*ds;

    hi.ath_floating_dB=setup.psy_ath_float[is]*(1.-ds)+
      setup.psy_ath_float[is+1]*ds;
    hi.ath_absolute_dB=setup.psy_ath_abs[is]*(1.-ds)+
      setup.psy_ath_abs[is+1]*ds;

    hi.amplitude_track_dBpersec=-6.;
    hi.trigger_setting=hi.base_setting;

    for(i=0;i<4;i++){
      hi.block[i].tone_mask_setting=hi.base_setting;
      hi.block[i].tone_peaklimit_setting=hi.base_setting;
      hi.block[i].noise_bias_setting=hi.base_setting;
      hi.block[i].noise_compand_setting=hi.base_setting;
    }

    return(ret);
  }

  private int setVBR( int channels, int  rate,  float quality){

    quality+=.0000001;
    if(quality>=1.)quality=.9999f;

    getSetupTemplate(channels,rate,quality,0);
    if(hi.setup == null)return Const.OV_EIMPL;

    return setupSettingo(channels,rate);
  }

  public int initVBR(Info vi,  int channels,  int rate,
                             float base_quality /* 0. to 1. */ ){
    this.vi = vi;
    this.ci = vi.getCodecSetup();
    this.hi=ci.hiEncSet;

    int ret=0;

    ret=setVBR(channels,rate,base_quality);

    if (ret != 0) {
      vi.clear();
      return ret;
    }
    ret = setSetupInit();
    if (ret != 0){
      vi.clear();
    }
    return (ret);
  }

  private int setManaged( int channels, int rate,  int max_bitrate,
                         int nominal_bitrate,  int min_bitrate){

    double tnominal=nominal_bitrate;
    int ret=0;

    if(nominal_bitrate<=0.){
      if(max_bitrate>0.){
        if(min_bitrate>0.)
          nominal_bitrate=(int)((max_bitrate+min_bitrate)*.5);
        else
          nominal_bitrate=(int)(max_bitrate*.875);
      }else{
        if(min_bitrate>0.){
          nominal_bitrate=min_bitrate;
        }else{
          return(Const.OV_EINVAL);
        }
      }
    }

    getSetupTemplate(channels,rate,nominal_bitrate,1);
    if(hi.setup != null)return Const.OV_EIMPL;

    ret=setupSettingo(channels,rate);
    if(ret == 0){
      vi.clear();
      return ret;
    }

    /* initialize management with sane defaults */
    hi.managed=1;
    hi.bitrate_min=min_bitrate;
    hi.bitrate_max=max_bitrate;
    hi.bitrate_av=(int)(tnominal);
    hi.bitrate_av_damp=1.5f; /* full range in no less than 1.5 second */
    hi.bitrate_reservoir=nominal_bitrate*2;
    hi.bitrate_reservoir_bias=.1; /* bias toward hoarding bits */

    return(ret);

  }

  public int init(Info vi, int channels,  int rate, int max_bitrate,
           int nominal_bitrate,  int min_bitrate){

    this.vi = vi;
    this.ci=vi.getCodecSetup();
    this.hi=ci.hiEncSet;

    int ret=setManaged(channels,rate,  max_bitrate, nominal_bitrate,  min_bitrate);

    if(ret == 0){
      vi.clear();
      return(ret);
    }

    ret=setSetupInit();
    if(ret == 0)
      vi.clear();
    return(ret);
  }


  private int setCtl( int number,Object arg){
    if(vi != null){

      int setp=(number&0xf); /* a read request has a low nibble of 0 */

      if((setp & hi.set_in_stone)==0)return(Const.OV_EINVAL);

      switch(number){

      /* now deprecated *****************/
      case OvectlRatemanageArg.OV_ECTL_RATEMANAGE_GET:
        {

          OvectlRatemanageArg ai = (OvectlRatemanageArg)arg;

          ai.management_active=hi.managed;
          ai.bitrate_hard_window=ai.bitrate_av_window=
            (double)(hi.bitrate_reservoir/vi.rate);
          ai.bitrate_av_window_center=1.;
          ai.bitrate_hard_min=hi.bitrate_min;
          ai.bitrate_hard_max=hi.bitrate_max;
          ai.bitrate_av_lo=hi.bitrate_av;
          ai.bitrate_av_hi=hi.bitrate_av;

        }
        return(0);

      /* now deprecated *****************/
      case OvectlRatemanageArg.OV_ECTL_RATEMANAGE_SET:
        {
          OvectlRatemanageArg ai = (OvectlRatemanageArg)arg;
          if(ai==null){
            hi.managed=0;
          }else{
            hi.managed=ai.management_active;
            setCtl(OvectlRatemanageArg.OV_ECTL_RATEMANAGE_AVG,arg);
            setCtl(OvectlRatemanageArg.OV_ECTL_RATEMANAGE_HARD,arg);
          }
        }
        return 0;

      /* now deprecated *****************/
      case OvectlRatemanageArg.OV_ECTL_RATEMANAGE_AVG:
        {
          OvectlRatemanageArg ai = (OvectlRatemanageArg)arg;
          if(ai==null){
            hi.bitrate_av=0;
          }else{
            hi.bitrate_av=(int)((ai.bitrate_av_lo+ai.bitrate_av_hi)*.5);
          }
        }
        return(0);
      /* now deprecated *****************/
      case OvectlRatemanageArg.OV_ECTL_RATEMANAGE_HARD:
        {
          OvectlRatemanageArg ai = (OvectlRatemanageArg)arg;
          if(ai==null){
            hi.bitrate_min=0;
            hi.bitrate_max=0;
          }else{
            hi.bitrate_min=ai.bitrate_hard_min;
            hi.bitrate_max=ai.bitrate_hard_max;
            hi.bitrate_reservoir=(int)(ai.bitrate_hard_window*(hi.bitrate_max+hi.bitrate_min)*.5);
          }
          if(hi.bitrate_reservoir<128.)
            hi.bitrate_reservoir=(int)128.;
        }
        return(0);

        /* replacement ratemanage interface */
      case OvectlRatemanageArg.OV_ECTL_RATEMANAGE2_GET:
        {
          OvectlRatemanageArg2 ai = (OvectlRatemanageArg2)arg;
          if(ai==null)return Const.OV_EINVAL;

          ai.management_active=hi.managed;
          ai.bitrate_limit_min_kbps=hi.bitrate_min;
          ai.bitrate_limit_max_kbps=hi.bitrate_max;
          ai.bitrate_average_kbps=hi.bitrate_av;
          ai.bitrate_average_damping=hi.bitrate_av_damp;
          ai.bitrate_limit_reservoir_bits=hi.bitrate_reservoir;
          ai.bitrate_limit_reservoir_bias=hi.bitrate_reservoir_bias;
        }
        return (0);
      case OvectlRatemanageArg.OV_ECTL_RATEMANAGE2_SET:
        {
          OvectlRatemanageArg2 ai = (OvectlRatemanageArg2)arg;
          if(ai==null){
            hi.managed=0;
          }else{
            /* sanity check; only catch invariant violations */
            if(ai.bitrate_limit_min_kbps>0 &&
               ai.bitrate_average_kbps>0 &&
               ai.bitrate_limit_min_kbps>ai.bitrate_average_kbps)
              return Const.OV_EINVAL;

            if(ai.bitrate_limit_max_kbps>0 &&
               ai.bitrate_average_kbps>0 &&
               ai.bitrate_limit_max_kbps<ai.bitrate_average_kbps)
              return Const.OV_EINVAL;

            if(ai.bitrate_limit_min_kbps>0 &&
               ai.bitrate_limit_max_kbps>0 &&
               ai.bitrate_limit_min_kbps>ai.bitrate_limit_max_kbps)
              return Const.OV_EINVAL;

            if(ai.bitrate_average_damping <= 0.)
              return Const.OV_EINVAL;

            if(ai.bitrate_limit_reservoir_bits < 0)
              return Const.OV_EINVAL;

            if(ai.bitrate_limit_reservoir_bias < 0.)
              return Const.OV_EINVAL;

            if(ai.bitrate_limit_reservoir_bias > 1.)
              return Const.OV_EINVAL;

            hi.managed=ai.management_active;
            hi.bitrate_min=ai.bitrate_limit_min_kbps;
            hi.bitrate_max=ai.bitrate_limit_max_kbps;
            hi.bitrate_av=ai.bitrate_average_kbps;
            hi.bitrate_av_damp=ai.bitrate_average_damping;
            hi.bitrate_reservoir=ai.bitrate_limit_reservoir_bits;
            hi.bitrate_reservoir_bias=ai.bitrate_limit_reservoir_bias;
          }
        }
        return 0;

      case OvectlRatemanageArg.OV_ECTL_LOWPASS_GET:
        {
          Double farg=(Double )arg;
          farg= new Double( hi.lowpass_kHz);
        }
        return(0);
      case OvectlRatemanageArg.OV_ECTL_LOWPASS_SET:
        {
          Double farg=(Double )arg;
          hi.lowpass_kHz=farg.doubleValue();

          if(hi.lowpass_kHz<2.)hi.lowpass_kHz=2.;
          if(hi.lowpass_kHz>99.)hi.lowpass_kHz=99.;
        }
        return(0);
      case OvectlRatemanageArg.OV_ECTL_IBLOCK_GET:
        {
          Double farg=(Double )arg;
          farg=new Double(hi.impulse_noisetune);
        }
        return(0);
      case OvectlRatemanageArg.OV_ECTL_IBLOCK_SET:
        {
          Double farg=(Double )arg;
          hi.impulse_noisetune=farg.doubleValue();

          if(hi.impulse_noisetune>0.)hi.impulse_noisetune=0.;
          if(hi.impulse_noisetune<-15.)hi.impulse_noisetune=-15.;
        }
        return(0);
      }


      return(Const.OV_EIMPL);
    }
    return(Const.OV_EINVAL);

  }

}