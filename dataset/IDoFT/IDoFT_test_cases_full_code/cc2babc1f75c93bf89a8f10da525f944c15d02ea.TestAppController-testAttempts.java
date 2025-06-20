/** 
 * Test method 'conf'. Should set AttemptsPage class for rendering or print information about error
 */
@Test public void testAttempts(){
  appController.getProperty().remove(AMParams.TASK_TYPE);
  when(job.checkAccess(any(UserGroupInformation.class),any(JobACL.class))).thenReturn(false);
  appController.attempts();
  verify(appController.response()).setContentType(MimeType.TEXT);
  assertEquals("Access denied: User user does not have permission to view job job_01_01",appController.getData());
  when(job.checkAccess(any(UserGroupInformation.class),any(JobACL.class))).thenReturn(true);
  appController.getProperty().remove(AMParams.TASK_ID);
  appController.attempts();
  assertEquals("Access denied: User user does not have permission to view job job_01_01",appController.getData());
  appController.getProperty().put(AMParams.TASK_ID,taskId);
  appController.attempts();
  assertEquals("Bad request: missing task-type.",appController.getProperty().get("title"));
  appController.getProperty().put(AMParams.TASK_TYPE,"m");
  appController.attempts();
  assertEquals("Bad request: missing attempt-state.",appController.getProperty().get("title"));
  appController.getProperty().put(AMParams.ATTEMPT_STATE,"State");
  appController.attempts();
  assertEquals(AttemptsPage.class,appController.getClazz());
}
