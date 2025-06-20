@Test @org.activiti.engine.test.Deployment(resources="org/activiti/engine/test/api/v6/Activiti6Test.testOneTaskProcess.bpmn20.xml") public void testOneTaskProcessCleanupInMiddleOfProcess(){
assertNotNull(processInstance);
assertFalse(processInstance.isEnded());
assertEquals("The famous task",task.getName());
assertEquals("kermit",task.getAssignee());
}