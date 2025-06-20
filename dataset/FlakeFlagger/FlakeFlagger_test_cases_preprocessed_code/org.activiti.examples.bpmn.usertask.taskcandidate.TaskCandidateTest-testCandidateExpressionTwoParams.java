@Deployment public void testCandidateExpressionTwoParams(){
assertEquals(1,taskService.createTaskQuery().taskCandidateUser(KERMIT,KERMITSGROUPS).count());
assertEquals(1,taskService.createTaskQuery().taskCandidateGroup("sales").count());
}