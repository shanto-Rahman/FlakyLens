@Deployment public void testSetAssigneeThroughSpringService(){
assertEquals(1,taskService.createTaskQuery().taskAssignee("Kermit The Frog").count());
}