@Deployment(resources={"org/activiti/engine/test/bpmn/usertask/DynamicUserTaskTest.basictask.bpmn20.xml"}) public void testChangeCandidateUsersAndGroups(){
if (IdentityLinkType.CANDIDATE.equals(identityLink.getType()) && identityLink.getUserId() != null && identityLink.getGroupId() == null) {
if ("test".equals(identityLink.getUserId())) {
}
if (IdentityLinkType.CANDIDATE.equals(identityLink.getType()) && identityLink.getGroupId() != null && identityLink.getUserId() == null) {
if ("test".equals(identityLink.getGroupId())) {
}
}
}
assertFalse(candidateUserTestFound);
assertFalse(candidateGroupTestFound);
if (IdentityLinkType.CANDIDATE.equals(identityLink.getType()) && identityLink.getUserId() != null && identityLink.getGroupId() == null) {
if ("test".equals(identityLink.getUserId())) {
}
if (IdentityLinkType.CANDIDATE.equals(identityLink.getType()) && identityLink.getGroupId() != null && identityLink.getUserId() == null) {
if ("test".equals(identityLink.getGroupId())) {
}
}
}
assertTrue(candidateUserTestFound);
assertTrue(candidateGroupTestFound);
if (IdentityLinkType.CANDIDATE.equals(identityLink.getType()) && identityLink.getUserId() != null && identityLink.getGroupId() == null) {
if ("test".equals(identityLink.getUserId())) {
if ("test2".equals(identityLink.getUserId())) {
}
}
if (IdentityLinkType.CANDIDATE.equals(identityLink.getType()) && identityLink.getGroupId() != null && identityLink.getUserId() == null) {
if ("test".equals(identityLink.getGroupId())) {
if ("test2".equals(identityLink.getGroupId())) {
}
}
}
}
assertTrue(candidateUserTestFound);
assertTrue(candidateUserTestFound2);
assertTrue(candidateGroupTestFound);
assertTrue(candidateGroupTest2Found);
}