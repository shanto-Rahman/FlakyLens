@Deployment public void testMultipleCandidateUsers(){
assertEquals(1,taskService.createTaskQuery().taskCandidateUser(GONZO,GONZOSGROUPS).list().size());
assertEquals(1,taskService.createTaskQuery().taskCandidateUser(KERMIT,KERMITSGROUPS).list().size());
assertEquals(1,tasks.size());
assertEquals(1,task.getProcessVariables().size());
assertEquals(1,task.getTaskLocalVariables().size());
assertEquals(1,tasks.size());
assertEquals(1,task.getProcessVariables().size());
assertEquals(1,task.getTaskLocalVariables().size());
}