@Deployment public void testUseSignalForExceptionsBetweenParallelPaths(){
assertEquals("Enter developers",task.getName());
assertEquals("Develop specifications",taskService.createTaskQuery().taskAssignee("developerOne").singleResult().getName());
assertEquals("Develop specifications",taskService.createTaskQuery().taskAssignee("developerTwo").singleResult().getName());
assertEquals("Develop specifications",taskService.createTaskQuery().taskAssignee("developerThree").singleResult().getName());
assertEquals("Negotiate with client",task.getName());
assertEquals(0,taskService.createTaskQuery().count());
assertEquals(0,runtimeService.createExecutionQuery().count());
}