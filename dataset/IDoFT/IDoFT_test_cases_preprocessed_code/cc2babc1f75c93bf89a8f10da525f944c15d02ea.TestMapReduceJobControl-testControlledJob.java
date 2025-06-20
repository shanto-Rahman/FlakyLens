@Test(timeout=30000) public void testControlledJob() throws Exception {
Job job1=MapReduceTestUtil.createCopyJob(conf,outdir_1,indir);//RW
while (cjob1.getJobState() != ControlledJob.State.RUNNING) //RW
Thread.sleep(100);
Assert.assertNotNull(cjob1.getMapredJobId());//RW
assertEquals("Some jobs failed",0,theControl.getFailedJobList().size());
}