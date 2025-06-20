@Test public void testMRAppMasterMidLock() throws IOException, InterruptedException {
conf.set(MRJobConfig.MR_AM_STAGING_DIR,stagingDir);//RW
assertTrue(caught);
assertTrue(appMaster.errorHappenedShutDown);
assertEquals(JobStateInternal.ERROR,appMaster.forcedState);
}