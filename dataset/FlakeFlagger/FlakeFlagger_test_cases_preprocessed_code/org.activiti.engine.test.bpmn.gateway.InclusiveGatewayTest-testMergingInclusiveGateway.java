@Deployment public void testMergingInclusiveGateway(){
assertEquals(1,taskService.createTaskQuery().count());
}