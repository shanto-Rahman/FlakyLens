@Deployment public void testInitiatorWithWhiteSpaceInExpression(){
assertEquals(1,taskService.createTaskQuery().taskAssignee("bono").count());
}