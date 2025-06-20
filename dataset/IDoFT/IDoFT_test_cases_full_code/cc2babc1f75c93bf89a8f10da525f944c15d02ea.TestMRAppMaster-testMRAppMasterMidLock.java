@Test public void testMRAppMasterMidLock() throws IOException, InterruptedException {
  String applicationAttemptIdStr="appattempt_1317529182569_0004_000002";
  String containerIdStr="container_1317529182569_0004_000002_1";
  String userName="TestAppMasterUser";
  JobConf conf=new JobConf();
  conf.set(MRJobConfig.MR_AM_STAGING_DIR,stagingDir);
  conf.setInt(org.apache.hadoop.mapreduce.lib.output.FileOutputCommitter.FILEOUTPUTCOMMITTER_ALGORITHM_VERSION,1);
  ApplicationAttemptId applicationAttemptId=ApplicationAttemptId.fromString(applicationAttemptIdStr);
  JobId jobId=TypeConverter.toYarn(TypeConverter.fromYarn(applicationAttemptId.getApplicationId()));
  Path start=MRApps.getStartJobCommitFile(conf,userName,jobId);
  FileSystem fs=FileSystem.get(conf);
  fs.create(start).close();
  ContainerId containerId=ContainerId.fromString(containerIdStr);
  MRAppMaster appMaster=new MRAppMasterTest(applicationAttemptId,containerId,"host",-1,-1,System.currentTimeMillis(),false,false);
  boolean caught=false;
  try {
    MRAppMaster.initAndStartAppMaster(appMaster,conf,userName);
  }
 catch (  IOException e) {
    LOG.info("Caught expected Exception",e);
    caught=true;
  }
  assertTrue(caught);
  assertTrue(appMaster.errorHappenedShutDown);
  assertEquals(JobStateInternal.ERROR,appMaster.forcedState);
  appMaster.stop();
  verifyFailedStatus((MRAppMasterTest)appMaster,"FAILED");
}
