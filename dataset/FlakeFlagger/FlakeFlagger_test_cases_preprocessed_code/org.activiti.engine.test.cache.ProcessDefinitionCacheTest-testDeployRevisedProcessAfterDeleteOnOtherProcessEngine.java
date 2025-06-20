public void testDeployRevisedProcessAfterDeleteOnOtherProcessEngine(){
assertEquals("original task",task.getName());
assertEquals(0,repositoryService2.createDeploymentQuery().count());
assertEquals(0,runtimeService2.createProcessInstanceQuery().count());
assertEquals("revised task",task.getName());
}