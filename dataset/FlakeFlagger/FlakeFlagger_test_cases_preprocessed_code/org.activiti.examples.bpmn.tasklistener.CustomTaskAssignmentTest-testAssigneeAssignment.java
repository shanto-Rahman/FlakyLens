@Deployment public void testAssigneeAssignment(){
assertNotNull(taskService.createTaskQuery().taskAssignee("kermit").singleResult());
assertEquals(0,taskService.createTaskQuery().taskAssignee("fozzie").count());
assertEquals(0,taskService.createTaskQuery().taskAssignee("gonzo").count());
}