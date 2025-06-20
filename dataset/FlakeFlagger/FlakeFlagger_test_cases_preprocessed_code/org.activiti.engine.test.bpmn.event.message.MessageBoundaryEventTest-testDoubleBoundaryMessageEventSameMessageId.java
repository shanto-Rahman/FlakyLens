public void testDoubleBoundaryMessageEventSameMessageId(){
fail("Deployment should fail because Activiti cannot handle two boundary message events with same messageId.");
assertEquals(0,repositoryService.createDeploymentQuery().count());
}