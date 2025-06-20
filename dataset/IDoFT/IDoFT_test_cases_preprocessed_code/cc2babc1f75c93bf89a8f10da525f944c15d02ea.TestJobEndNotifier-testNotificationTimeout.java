/** 
 * Validate that the notification times out after reaching mapreduce.job.end-notification.timeout.
 */
@Test public void testNotificationTimeout() throws InterruptedException {
assertEquals(1,DelayServlet.calledTimes);//RW
assertTrue(elapsedTime < 2000);
}