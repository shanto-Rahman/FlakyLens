@Test(timeout=90000) public void testJobHistoryData() throws IOException, InterruptedException, AvroRemoteException, ClassNotFoundException {
  if (!(new File(MiniMRYarnCluster.APPJAR)).exists()) {
    LOG.info("MRAppJar " + MiniMRYarnCluster.APPJAR + " not found. Not running test.");
    return;
  }
  SleepJob sleepJob=new SleepJob();
  sleepJob.setConf(mrCluster.getConfig());
  Job job=sleepJob.createJob(3,2,1000,1,500,1);
  job.setJarByClass(SleepJob.class);
  job.addFileToClassPath(APP_JAR);
  job.waitForCompletion(true);
  Counters counterMR=job.getCounters();
  JobId jobId=TypeConverter.toYarn(job.getJobID());
  ApplicationId appID=jobId.getAppId();
  int pollElapsed=0;
  while (true) {
    Thread.sleep(1000);
    pollElapsed+=1000;
    if (TERMINAL_RM_APP_STATES.contains(mrCluster.getResourceManager().getRMContext().getRMApps().get(appID).getState())) {
      break;
    }
    if (pollElapsed >= 60000) {
      LOG.warn("application did not reach terminal state within 60 seconds");
      break;
    }
  }
  Assert.assertEquals(RMAppState.FINISHED,mrCluster.getResourceManager().getRMContext().getRMApps().get(appID).getState());
  Counters counterHS=job.getCounters();
  LOG.info("CounterHS " + counterHS);
  LOG.info("CounterMR " + counterMR);
  Assert.assertEquals(counterHS,counterMR);
  HSClientProtocol historyClient=instantiateHistoryProxy();
  GetJobReportRequest gjReq=Records.newRecord(GetJobReportRequest.class);
  gjReq.setJobId(jobId);
  JobReport jobReport=historyClient.getJobReport(gjReq).getJobReport();
  verifyJobReport(jobReport,jobId);
}
