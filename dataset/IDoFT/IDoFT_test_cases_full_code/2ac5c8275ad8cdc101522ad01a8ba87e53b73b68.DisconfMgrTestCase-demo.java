@Test public void demo(){
  new MockUp<DisconfCoreFactory>(){
    @Mock public DisconfCoreMgr getDisconfCoreMgr(    Registry registry) throws Exception {
      FetcherMgr fetcherMgr=FetcherFactory.getFetcherMgr();
      final WatchMgr watchMgr=new WatchMgrMock().getMockInstance();
      watchMgr.init("","",true);
      DisconfCoreMgr disconfCoreMgr=new DisconfCoreMgrImpl(watchMgr,fetcherMgr,registry);
      return disconfCoreMgr;
    }
  }
;
  try {
    LOGGER.info("================ BEFORE DISCONF ==============================");
    LOGGER.info("before disconf values:");
    LOGGER.info(String.valueOf("varA: " + confA.getVarA()));
    LOGGER.info(String.valueOf("varA2: " + confA.getVarA2()));
    LOGGER.info(String.valueOf("varAA: " + serviceA.getVarAA()));
    LOGGER.info("================ BEFORE DISCONF ==============================");
    Set<String> fileSet=new HashSet<String>();
    fileSet.add("atomserverl.properties");
    fileSet.add("atomserverm_slave.properties");
    DisconfCenterHostFilesStore.getInstance().addJustHostFileSet(fileSet);
    DisconfMgr.getInstance().setApplicationContext(applicationContext);
    DisconfMgr.getInstance().start(StringUtil.parseStringToStringList(ScanPackTestCase.SCAN_PACK_NAME,DisconfMgrBean.SCAN_SPLIT_TOKEN));
    LOGGER.info(DisconfStoreProcessorFactory.getDisconfStoreFileProcessor().confToString());
    LOGGER.info(DisconfStoreProcessorFactory.getDisconfStoreItemProcessor().confToString());
    LOGGER.info("================ AFTER DISCONF ==============================");
    LOGGER.info(String.valueOf("varA: " + confA.getVarA()));
    Assert.assertEquals(new Long(1000),confA.getVarA());
    LOGGER.info(String.valueOf("varA2: " + confA.getVarA2()));
    Assert.assertEquals(new Long(2000),confA.getVarA2());
    LOGGER.info(String.valueOf("varAA: " + serviceA.getVarAA()));
    Assert.assertEquals(new Integer(1000).intValue(),serviceA.getVarAA());
    LOGGER.info(String.valueOf("static var: " + StaticConf.getStaticvar()));
    Assert.assertEquals(new Integer(50).intValue(),StaticConf.getStaticvar());
    testDynamicGetter();
    LOGGER.info("================ AFTER DISCONF ==============================");
  }
 catch (  Exception e) {
    e.printStackTrace();
    Assert.assertTrue(false);
  }
}
