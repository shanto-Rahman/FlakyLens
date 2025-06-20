@Test(timeout=10000) public void testTaskProgress() throws Exception {
  JobConf job=new JobConf();
  job.setLong(MRJobConfig.TASK_PROGRESS_REPORT_INTERVAL,1000);
  Task task=new DummyTask();
  task.setConf(job);
  DummyTaskReporter reporter=new DummyTaskReporter(task);
  Thread t=new Thread(reporter);
  t.start();
  Thread.sleep(2100);
  task.setTaskDone();
  reporter.resetDoneFlag();
  t.join();
  Assert.assertEquals(statusUpdateTimes,2);
}
