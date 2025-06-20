@Deployment public void testMultipleTimersOnUserTask(){
assertEquals("First Task",task1.getName());
assertEquals(2,jobs.size());
assertNotNull(job);
assertEquals(1L,jobQuery.count());
assertEquals(2L,taskService.createTaskQuery().count());
assertEquals("First Task",taskList.get(0).getName());
assertEquals("Escalation Task 1",taskList.get(1).getName());
assertEquals(1L,taskService.createTaskQuery().count());
assertEquals("First Task",taskService.createTaskQuery().singleResult().getName());
assertEquals(0L,jobQuery.count());
assertEquals(2L,taskService.createTaskQuery().count());
assertEquals("First Task",taskList.get(0).getName());
assertEquals("Escalation Task 2",taskList.get(1).getName());
assertEquals(1L,taskService.createTaskQuery().count());
assertEquals("Escalation Task 2",escalationTask.getName());
}