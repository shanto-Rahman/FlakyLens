public void testMessageStartEventSubscriptionAfterDeploymentDelete(){
assertEquals(1,eventSubscriptions.size());
assertEquals(1,eventSubscriptions.size());
assertEquals(0,getAllEventSubscriptions().size());
assertEquals(1,getAllEventSubscriptions().size());
assertEquals(1,eventSubscriptions.size());
assertEquals(repositoryService.createProcessDefinitionQuery().deploymentId(deploymentId2).singleResult().getId(),eventSubscriptions.get(0).getProcessDefinitionId());
assertEquals(0,getAllEventSubscriptions().size());
}