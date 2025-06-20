@Test public void testParseDomain() throws Exception {
  TimelineDataManager tdm=PluginStoreTestUtils.getTdmWithMemStore(config);
  DomainLogInfo domainLogInfo=new DomainLogInfo(TEST_ATTEMPT_DIR_NAME,TEST_DOMAIN_FILE_NAME,UserGroupInformation.getLoginUser().getUserName());
  domainLogInfo.parseForStore(tdm,getTestRootPath(),true,jsonFactory,objMapper,fs);
  TimelineDomain resultDomain=tdm.getDomain("domain_1",UserGroupInformation.getLoginUser());
  assertNotNull(resultDomain);
  assertEquals(testDomain.getReaders(),resultDomain.getReaders());
  assertEquals(testDomain.getOwner(),resultDomain.getOwner());
  assertEquals(testDomain.getDescription(),resultDomain.getDescription());
}
