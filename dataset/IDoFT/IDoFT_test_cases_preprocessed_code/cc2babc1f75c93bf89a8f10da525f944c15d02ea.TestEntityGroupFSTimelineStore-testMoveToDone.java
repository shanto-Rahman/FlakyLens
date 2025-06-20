@Test public void testMoveToDone() throws Exception {
EntityGroupFSTimelineStore.AppLogs appLogs=store.new AppLogs(mainTestAppId,mainTestAppDirPath,AppState.COMPLETED);//RW
assertTrue(pathAfter.toString().contains(testDoneDirPath.toString()));//RW
}