@Test @org.activiti.engine.test.Deployment public void testSimpleNestedParallelGateway(){
assertNotNull(processInstance);
assertFalse(processInstance.isEnded());
assertEquals(4,tasks.size());
assertEquals("Task a",tasks.get(0).getName());
assertEquals("Task b1",tasks.get(1).getName());
assertEquals("Task b2",tasks.get(2).getName());
assertEquals("Task c",tasks.get(3).getName());
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
}