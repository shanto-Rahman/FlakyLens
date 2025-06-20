/** 
 * Validate that the notification times out after reaching mapreduce.job.end-notification.timeout.
 */
@Test public void testNotificationTimeout() throws InterruptedException {
  Configuration conf=new Configuration();
  conf.setInt("mapreduce.job.end-notification.timeout",1000);
  JobStatus jobStatus=createTestJobStatus("job_20130313155005308_0001",JobStatus.SUCCEEDED);
  JobConf jobConf=createTestJobConf(conf,0,baseUrl + "delay");
  long startTime=System.currentTimeMillis();
  JobEndNotifier.localRunnerNotification(jobConf,jobStatus);
  long elapsedTime=System.currentTimeMillis() - startTime;
  assertEquals(1,DelayServlet.calledTimes);
  assertTrue(elapsedTime < 2000);
}
