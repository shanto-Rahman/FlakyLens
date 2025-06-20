@Test public void testMRAppMasterFailLock() throws IOException, InterruptedException {
conf.set(MRJobConfig.MR_AM_STAGING_DIR,stagingDir);//RW
assertTrue(caught);
assertTrue(appMaster.errorHappenedShutDown);
assertEquals(JobStateInternal.FAILED,appMaster.forcedState);
}