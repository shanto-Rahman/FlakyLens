@Deployment public void testJoinAfterSubprocesses(){
assertNotNull(processInstance.getId());
assertEquals(2,taskService.createTaskQuery().count());
assertEquals(1,taskService.createTaskQuery().count());
assertNotNull(task);
assertNull(processInstance);
assertNotNull(processInstance.getId());
assertEquals(1,taskService.createTaskQuery().count());
assertEquals("a",task.getAssignee());
assertNotNull(task);
assertNull(processInstance);
fail();
assertTrue(e.getMessage().contains("No outgoing sequence flow"));
}