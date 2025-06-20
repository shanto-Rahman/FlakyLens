@Deployment public void testDirectSequenceFlow(){
assertNotNull(task);
assertEquals("theTask1",task.getTaskDefinitionKey());
assertEquals(0,runtimeService.createProcessInstanceQuery().processInstanceId(processInstance.getId()).count());
assertEquals(2,tasks.size());
assertEquals(0,runtimeService.createProcessInstanceQuery().processInstanceId(processInstance.getId()).count());
assertTrue(processInstance.isEnded());
}