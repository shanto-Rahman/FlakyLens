public void testDeleteOwner(){
assertNull(task.getOwner());
assertEquals(0,taskService.getIdentityLinksForTask(task.getId()).size());
}