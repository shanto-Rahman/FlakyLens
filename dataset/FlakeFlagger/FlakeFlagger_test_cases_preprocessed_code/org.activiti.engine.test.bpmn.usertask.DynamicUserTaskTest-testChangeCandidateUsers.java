@Deployment(resources={"org/activiti/engine/test/bpmn/usertask/DynamicUserTaskTest.basictask.bpmn20.xml"}) public void testChangeCandidateUsers(){
if (IdentityLinkType.CANDIDATE.equals(identityLink.getType()) && identityLink.getUserId() != null && identityLink.getGroupId() == null) {
if ("test".equals(identityLink.getUserId())) {
}
}
assertFalse(candidateUserTestFound);
if (IdentityLinkType.CANDIDATE.equals(identityLink.getType()) && identityLink.getUserId() != null && identityLink.getGroupId() == null) {
if ("test".equals(identityLink.getUserId())) {
}
}
assertTrue(candidateUserTestFound);
if (IdentityLinkType.CANDIDATE.equals(identityLink.getType()) && identityLink.getUserId() != null && identityLink.getGroupId() == null) {
if ("test".equals(identityLink.getUserId())) {
if ("test2".equals(identityLink.getUserId())) {
}
}
}
assertTrue(candidateUserTestFound);
assertTrue(candidateUserTest2Found);
}