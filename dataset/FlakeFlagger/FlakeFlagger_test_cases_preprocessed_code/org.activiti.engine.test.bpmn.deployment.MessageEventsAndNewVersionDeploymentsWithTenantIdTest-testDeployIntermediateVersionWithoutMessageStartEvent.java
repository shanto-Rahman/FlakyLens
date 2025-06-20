/** 
 * v1 -> has start message event v2 -> has no start message event v3 -> has start message event
 */
public void testDeployIntermediateVersionWithoutMessageStartEvent(){
assertEquals(1,getAllEventSubscriptions().size());
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
assertEquals(1,runtimeService.createProcessInstanceQuery().count());
assertEquals(0,getAllEventSubscriptions().size());
assertEquals(1,runtimeService.createProcessInstanceQuery().count());
fail();
assertEquals(1,runtimeService.createProcessInstanceQuery().count());
assertEquals(1,getAllEventSubscriptions().size());
assertEquals(1,runtimeService.createProcessInstanceQuery().count());
assertEquals(2,runtimeService.createProcessInstanceQuery().count());
assertEquals(repositoryService.createProcessDefinitionQuery().deploymentId(deploymentId3).singleResult().getId(),eventSubscriptions.get(0).getProcessDefinitionId());
}