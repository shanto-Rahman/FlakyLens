@Test @org.activiti.engine.test.Deployment public void testScriptTask(){
assertNotNull(processInstance);
assertFalse(processInstance.isEnded());
assertEquals(3,sumVariable.intValue());
assertNotNull(execution);
assertNull(runtimeService.createProcessInstanceQuery().processInstanceId(processInstance.getId()).singleResult());
}