@Test public void testMRAppMasterShutDownJob() throws Exception, InterruptedException {
  String applicationAttemptIdStr="appattempt_1317529182569_0004_000002";
  String containerIdStr="container_1317529182569_0004_000002_1";
  String userName="TestAppMasterUser";
  ApplicationAttemptId applicationAttemptId=ApplicationAttemptId.fromString(applicationAttemptIdStr);
  ContainerId containerId=ContainerId.fromString(containerIdStr);
  JobConf conf=new JobConf();
  conf.set(MRJobConfig.MR_AM_STAGING_DIR,stagingDir);
  File stagingDir=new File(MRApps.getStagingAreaDir(conf,userName).toString());
  stagingDir.mkdirs();
  MRAppMasterTest appMaster=spy(new MRAppMasterTest(applicationAttemptId,containerId,"host",-1,-1,System.currentTimeMillis(),false,true));
  MRAppMaster.initAndStartAppMaster(appMaster,conf,userName);
  doReturn(conf).when(appMaster).getConfig();
  appMaster.isLastAMRetry=true;
  doNothing().when(appMaster).serviceStop();
  appMaster.shutDownJob();
  Assert.assertTrue("Expected shutDownJob to terminate.",ExitUtil.terminateCalled());
  Assert.assertEquals("Expected shutDownJob to exit with status code of 0.",0,ExitUtil.getFirstExitException().status);
  ExitUtil.resetFirstExitException();
  String msg="Injected Exception";
  doThrow(new RuntimeException(msg)).when(appMaster).notifyIsLastAMRetry(anyBoolean());
  appMaster.shutDownJob();
  assertTrue("Expected message from ExitUtil.ExitException to be " + msg,ExitUtil.getFirstExitException().getMessage().contains(msg));
  Assert.assertEquals("Expected shutDownJob to exit with status code of 1.",1,ExitUtil.getFirstExitException().status);
}
