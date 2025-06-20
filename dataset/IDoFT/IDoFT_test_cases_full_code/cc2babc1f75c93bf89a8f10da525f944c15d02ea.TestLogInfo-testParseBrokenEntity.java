@Test public void testParseBrokenEntity() throws Exception {
  TimelineDataManager tdm=PluginStoreTestUtils.getTdmWithMemStore(config);
  EntityLogInfo testLogInfo=new EntityLogInfo(TEST_ATTEMPT_DIR_NAME,TEST_BROKEN_FILE_NAME,UserGroupInformation.getLoginUser().getUserName());
  DomainLogInfo domainLogInfo=new DomainLogInfo(TEST_ATTEMPT_DIR_NAME,TEST_BROKEN_FILE_NAME,UserGroupInformation.getLoginUser().getUserName());
  testLogInfo.parseForStore(tdm,getTestRootPath(),true,jsonFactory,objMapper,fs);
  domainLogInfo.parseForStore(tdm,getTestRootPath(),true,jsonFactory,objMapper,fs);
  tdm.close();
}
