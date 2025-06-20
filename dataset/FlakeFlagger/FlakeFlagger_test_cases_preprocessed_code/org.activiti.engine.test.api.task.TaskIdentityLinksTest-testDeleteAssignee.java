public void testDeleteAssignee(){
assertNull(task.getAssignee());
assertEquals(0,taskService.getIdentityLinksForTask(task.getId()).size());
}