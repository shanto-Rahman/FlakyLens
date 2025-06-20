public void testDeleteDeploymentWithStartSignalEvents7(){
assertEquals(0,runtimeService.createExecutionQuery().count());
assertEquals(0,runtimeService.createExecutionQuery().count());
assertEquals(1,runtimeService.createProcessInstanceQuery().count());
}