@Test @Deployment public void testGetVariableEquals(){
assertEquals("B",taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult().getName());
assertEquals("B",taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult().getName());
assertEquals("A",taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult().getName());
}