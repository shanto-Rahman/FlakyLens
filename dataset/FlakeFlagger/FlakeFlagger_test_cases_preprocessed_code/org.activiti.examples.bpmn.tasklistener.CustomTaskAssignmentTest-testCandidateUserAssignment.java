@Deployment public void testCandidateUserAssignment(){
assertEquals(1,taskService.createTaskQuery().taskCandidateUser("kermit",null).count());
assertEquals(1,taskService.createTaskQuery().taskCandidateUser("fozzie",null).count());
assertEquals(0,taskService.createTaskQuery().taskCandidateUser("gonzo",null).count());
}