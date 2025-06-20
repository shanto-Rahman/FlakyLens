@Deployment public void testCandidateExpressionOneParam(){
assertEquals(1,taskService.createTaskQuery().taskCandidateUser(KERMIT,KERMITSGROUPS).list().size());
}