@Deployment public void testOverwriteExistingAssignmentsFromVariable(){
assertNotNull(taskService.createTaskQuery().taskAssignee("gonzo").singleResult());
assertEquals(0,taskService.createTaskQuery().taskAssignee("fozzie").count());
assertEquals(0,taskService.createTaskQuery().taskAssignee("kermit").count());
}