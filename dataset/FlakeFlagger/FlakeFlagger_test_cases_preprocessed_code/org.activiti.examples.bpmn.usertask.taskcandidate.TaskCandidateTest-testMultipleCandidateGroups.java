@Deployment public void testMultipleCandidateGroups(){
assertTrue(tasks.isEmpty());
assertTrue(tasks.isEmpty());
assertEquals(1,taskService.createTaskQuery().taskCandidateUser(KERMIT,KERMITSGROUPS).list().size());
assertEquals(1,taskService.createTaskQuery().taskCandidateUser(GONZO,GONZOSGROUPS).list().size());
assertEquals(1,taskService.createTaskQuery().taskCandidateGroup("management").count());
assertEquals(1,taskService.createTaskQuery().taskCandidateGroup("accountancy").count());
assertEquals(0,taskService.createTaskQuery().taskCandidateGroup("sales").count());
assertEquals("Approve expenses",task.getName());
assertTrue(taskService.createTaskQuery().taskCandidateUser(KERMIT,KERMITSGROUPS).list().isEmpty());
assertTrue(taskService.createTaskQuery().taskCandidateUser(GONZO,GONZOSGROUPS).list().isEmpty());
assertEquals(0,taskService.createTaskQuery().taskCandidateGroup("management").count());
assertEquals(1,taskService.createTaskQuery().taskAssignee(GONZO).count());
assertEquals(0,taskService.createTaskQuery().taskAssignee(KERMIT).count());
}