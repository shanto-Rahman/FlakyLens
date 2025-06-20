@Test public void testMoveToDone() throws Exception {
  EntityGroupFSTimelineStore.AppLogs appLogs=store.new AppLogs(mainTestAppId,mainTestAppDirPath,AppState.COMPLETED);
  Path pathBefore=appLogs.getAppDirPath();
  appLogs.moveToDone();
  Path pathAfter=appLogs.getAppDirPath();
  assertNotEquals(pathBefore,pathAfter);
  assertTrue(pathAfter.toString().contains(testDoneDirPath.toString()));
}
