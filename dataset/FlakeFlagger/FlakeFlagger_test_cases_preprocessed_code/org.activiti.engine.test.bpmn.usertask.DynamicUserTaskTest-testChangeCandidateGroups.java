@Deployment(resources={"org/activiti/engine/test/bpmn/usertask/DynamicUserTaskTest.basictask.bpmn20.xml"}) public void testChangeCandidateGroups(){
if (IdentityLinkType.CANDIDATE.equals(identityLink.getType()) && identityLink.getGroupId() != null && identityLink.getUserId() == null) {
if ("test".equals(identityLink.getGroupId())) {
}
}
assertFalse(candidateGroupTestFound);
if (IdentityLinkType.CANDIDATE.equals(identityLink.getType()) && identityLink.getGroupId() != null && identityLink.getUserId() == null) {
if ("test".equals(identityLink.getGroupId())) {
}
}
assertTrue(candidateGroupTestFound);
if (IdentityLinkType.CANDIDATE.equals(identityLink.getType()) && identityLink.getGroupId() != null && identityLink.getUserId() == null) {
if ("test".equals(identityLink.getGroupId())) {
if ("test2".equals(identityLink.getGroupId())) {
}
}
}
assertTrue(candidateGroupTestFound);
assertTrue(candidateGroupTest2Found);
}