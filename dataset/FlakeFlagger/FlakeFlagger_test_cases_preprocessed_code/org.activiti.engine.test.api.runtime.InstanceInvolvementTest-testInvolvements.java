@Deployment(resources={"org/activiti/engine/test/api/runtime/threeParallelTasks.bpmn20.xml"}) public void testInvolvements(){
assertEquals(3,tasks.size());
assertTrue(containsIdentityLink(identityLinks,"user1","starter"));
assertTrue(containsIdentityLink(identityLinks,"user2","participant"));
assertTrue(containsIdentityLink(identityLinks,"user3","participant"));
assertTrue(containsIdentityLink(identityLinks,"user4","custom"));
assertEquals(4,identityLinks.size());
}