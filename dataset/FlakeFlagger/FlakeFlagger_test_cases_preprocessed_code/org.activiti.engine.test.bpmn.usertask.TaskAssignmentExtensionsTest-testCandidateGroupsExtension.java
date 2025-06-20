@Deployment public void testCandidateGroupsExtension(){
assertEquals(1,tasks.size());
assertEquals("make profit",tasks.get(0).getName());
assertEquals(1,tasks.size());
assertEquals("make profit",tasks.get(0).getName());
assertEquals(1,query.taskCandidateGroup("management").count());
assertEquals(1,query.taskCandidateGroup("accountancy").count());
}