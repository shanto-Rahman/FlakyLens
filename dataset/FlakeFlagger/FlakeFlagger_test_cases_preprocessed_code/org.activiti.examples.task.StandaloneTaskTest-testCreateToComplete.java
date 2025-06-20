public void testCreateToComplete(){
assertEquals(1,tasks.size());
assertEquals("testTask",tasks.get(0).getName());
assertEquals(1,tasks.size());
assertEquals("testTask",tasks.get(0).getName());
assertEquals(1,tasks.size());
assertEquals("Update name",tasks.get(0).getName());
assertTrue(taskService.createTaskQuery().taskCandidateUser("kermit").list().isEmpty());
assertTrue(taskService.createTaskQuery().taskCandidateUser("gonzo").list().isEmpty());
assertNull(taskService.createTaskQuery().taskId(taskId).singleResult());
}