@Deployment public void testAsyncUserTask(){
assertEquals(1,managementService.createJobQuery().count());
assertNull(runtimeService.getVariable(pid,"listener"));
assertNull(runtimeService.getVariable(pid,"taskListener"));
assertNull(taskService.createTaskQuery().singleResult());
assertNotNull(runtimeService.getVariable(pid,"listener"));
assertNotNull(runtimeService.getVariable(pid,"taskListener"));
assertNotNull(taskService.createTaskQuery().singleResult());
assertEquals(0,managementService.createJobQuery().count());
}