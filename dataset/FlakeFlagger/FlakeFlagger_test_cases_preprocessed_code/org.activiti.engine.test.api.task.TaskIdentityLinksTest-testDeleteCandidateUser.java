@Deployment(resources="org/activiti/engine/test/api/task/TaskIdentityLinksTest.testDeleteCandidateUser.bpmn20.xml") public void testDeleteCandidateUser(){
assertEquals(1,identityLinks.size());
assertEquals("user",identityLink.getUserId());
}