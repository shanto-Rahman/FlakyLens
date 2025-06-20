@Deployment public void testCandidateGroups(){
assertEquals(1,tasks.size());
assertEquals("theTask",tasks.get(0).getTaskDefinitionKey());
assertEquals(1,tasks.size());
assertEquals("theOtherTask",tasks.get(0).getTaskDefinitionKey());
}