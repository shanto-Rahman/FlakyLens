public void testDeleteDeploymentWithStartMessageEvents7(){
fail();
assertEquals(0,runtimeService.createExecutionQuery().count());
fail();
assertEquals(0,runtimeService.createExecutionQuery().count());
assertEquals(1,runtimeService.createProcessInstanceQuery().count());
}