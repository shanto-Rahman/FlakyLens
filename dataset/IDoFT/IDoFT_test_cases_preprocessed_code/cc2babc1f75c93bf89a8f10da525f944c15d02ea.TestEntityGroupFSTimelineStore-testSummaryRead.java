@Test public void testSummaryRead() throws Exception {
EntityGroupFSTimelineStore.AppLogs appLogs=store.new AppLogs(mainTestAppId,mainTestAppDirPath,AppState.COMPLETED);//RW
TimelineDataManager tdm=PluginStoreTestUtils.getTdmWithStore(config,store);//RW
assertEquals(entities.getEntities().size(),1);
assertEquals((Long)123L,entity.getStartTime());
assertEquals(numEntityReadBefore + 5L,summaryLogEntityRead.value());
}