@Test(timeout=30000) public void testControlledJob() throws Exception {
  LOG.info("Starting testControlledJob");
  Configuration conf=createJobConf();
  cleanupData(conf);
  Job job1=MapReduceTestUtil.createCopyJob(conf,outdir_1,indir);
  JobControl theControl=createDependencies(conf,job1);
  while (cjob1.getJobState() != ControlledJob.State.RUNNING) {
    try {
      Thread.sleep(100);
    }
 catch (    InterruptedException e) {
      break;
    }
  }
  Assert.assertNotNull(cjob1.getMapredJobId());
  waitTillAllFinished(theControl);
  assertEquals("Some jobs failed",0,theControl.getFailedJobList().size());
  theControl.stop();
}
