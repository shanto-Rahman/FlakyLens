public void testDeleteDeploymentWithStartSignalEvents6(){
assertEquals(0,runtimeService.createExecutionQuery().count());
assertEquals(0,runtimeService.createExecutionQuery().count());
assertEquals(0,runtimeService.createExecutionQuery().count());
}