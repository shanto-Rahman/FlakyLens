@Test public void testParseSummaryLogs() throws Exception {
  TimelineDataManager tdm=PluginStoreTestUtils.getTdmWithMemStore(config);
  MutableCounterLong scanned=store.metrics.getEntitiesReadToSummary();
  long beforeScan=scanned.value();
  EntityGroupFSTimelineStore.AppLogs appLogs=store.new AppLogs(mainTestAppId,mainTestAppDirPath,AppState.COMPLETED);
  appLogs.scanForLogs();
  appLogs.parseSummaryLogs(tdm);
  PluginStoreTestUtils.verifyTestEntities(tdm);
  assertEquals(beforeScan + 2L,scanned.value());
}
