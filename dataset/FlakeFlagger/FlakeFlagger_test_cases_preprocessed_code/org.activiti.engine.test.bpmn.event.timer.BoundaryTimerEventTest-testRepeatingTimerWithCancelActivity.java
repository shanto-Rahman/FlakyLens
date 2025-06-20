@Deployment public void testRepeatingTimerWithCancelActivity(){
assertEquals(1,managementService.createTimerJobQuery().count());
assertEquals(1,taskService.createTaskQuery().count());
assertEquals(1,managementService.createTimerJobQuery().count());
assertEquals(1,taskService.createTaskQuery().count());
}