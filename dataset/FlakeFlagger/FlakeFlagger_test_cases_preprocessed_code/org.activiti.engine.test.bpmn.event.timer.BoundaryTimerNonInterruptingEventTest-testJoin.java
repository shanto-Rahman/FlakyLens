@Deployment public void testJoin(){
assertEquals("Main Task",task1.getName());
assertEquals(1,jobs.size());
assertEquals(0L,jobQuery.count());
assertEquals(2L,taskService.createTaskQuery().count());
assertEquals(1L,taskService.createTaskQuery().count());
assertEquals("Escalation Task",task2.getName());
}