@Test public void testSummaryRead() throws Exception {
  EntityGroupFSTimelineStore.AppLogs appLogs=store.new AppLogs(mainTestAppId,mainTestAppDirPath,AppState.COMPLETED);
  MutableCounterLong summaryLogEntityRead=store.metrics.getGetEntityToSummaryOps();
  long numEntityReadBefore=summaryLogEntityRead.value();
  TimelineDataManager tdm=PluginStoreTestUtils.getTdmWithStore(config,store);
  appLogs.scanForLogs();
  appLogs.parseSummaryLogs(tdm);
  PluginStoreTestUtils.verifyTestEntities(tdm);
  TimelineEntities entities=tdm.getEntities("type_1",null,null,null,null,null,null,null,EnumSet.allOf(TimelineReader.Field.class),UserGroupInformation.getLoginUser());
  assertEquals(entities.getEntities().size(),1);
  for (  TimelineEntity entity : entities.getEntities()) {
    assertEquals((Long)123L,entity.getStartTime());
  }
  assertEquals(numEntityReadBefore + 5L,summaryLogEntityRead.value());
}
