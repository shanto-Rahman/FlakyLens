/** 
 * Test method 'conf'. Should set AttemptsPage class for rendering or print information about error
 */
@Test public void testAttempts(){
assertEquals("Access denied: User user does not have permission to view job job_01_01",appController.getData());
assertEquals("Access denied: User user does not have permission to view job job_01_01",appController.getData());
assertEquals("Bad request: missing task-type.",appController.getProperty().get("title"));
assertEquals("Bad request: missing attempt-state.",appController.getProperty().get("title"));
assertEquals(AttemptsPage.class,appController.getClazz());
}