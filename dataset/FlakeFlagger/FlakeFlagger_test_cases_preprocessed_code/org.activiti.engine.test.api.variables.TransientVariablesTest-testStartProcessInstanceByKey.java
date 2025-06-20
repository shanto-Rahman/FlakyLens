@Deployment public void testStartProcessInstanceByKey(){
assertEquals("A",task.getName());
assertEquals(0,runtimeService.getVariables(processInstance.getId()).size());
assertEquals("B",task.getName());
assertEquals(0,runtimeService.getVariables(processInstance.getId()).size());
assertEquals("Default",task.getName());
assertEquals(0,runtimeService.getVariables(processInstance.getId()).size());
}