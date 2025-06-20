@Test public void testParseSummaryLogs() throws Exception {
TimelineDataManager tdm=PluginStoreTestUtils.getTdmWithMemStore(config);//RW
EntityGroupFSTimelineStore.AppLogs appLogs=store.new AppLogs(mainTestAppId,mainTestAppDirPath,AppState.COMPLETED);//RW
assertEquals(beforeScan + 2L,scanned.value());
}