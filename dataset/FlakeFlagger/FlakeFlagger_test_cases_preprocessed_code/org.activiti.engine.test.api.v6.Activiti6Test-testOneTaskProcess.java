@Test @org.activiti.engine.test.Deployment public void testOneTaskProcess(){
assertNotNull(processInstance);
assertFalse(processInstance.isEnded());
assertEquals("The famous task",task.getName());
assertEquals("kermit",task.getAssignee());
}