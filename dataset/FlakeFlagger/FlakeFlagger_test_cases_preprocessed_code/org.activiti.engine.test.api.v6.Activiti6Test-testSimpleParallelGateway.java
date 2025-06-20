@Test @org.activiti.engine.test.Deployment public void testSimpleParallelGateway(){
assertNotNull(processInstance);
assertFalse(processInstance.isEnded());
assertEquals(2,tasks.size());
assertEquals("Task a",tasks.get(0).getName());
assertEquals("Task b",tasks.get(1).getName());
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
}