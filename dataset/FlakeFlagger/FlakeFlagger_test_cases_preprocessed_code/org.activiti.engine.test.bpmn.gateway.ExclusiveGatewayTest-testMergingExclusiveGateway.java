@Deployment public void testMergingExclusiveGateway(){
assertEquals(3,taskService.createTaskQuery().count());
}