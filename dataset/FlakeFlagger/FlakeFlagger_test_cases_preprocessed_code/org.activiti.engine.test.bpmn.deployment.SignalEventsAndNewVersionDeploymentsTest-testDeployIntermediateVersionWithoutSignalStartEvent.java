/** 
 * v1 -> has start signal event v2 -> has no start signal event v3 -> has start signal event
 */
public void testDeployIntermediateVersionWithoutSignalStartEvent(){
assertEquals(1,getAllEventSubscriptions().size());
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
assertEquals(1,runtimeService.createProcessInstanceQuery().count());
assertEquals(0,getAllEventSubscriptions().size());
assertEquals(1,runtimeService.createProcessInstanceQuery().count());
assertEquals(1,runtimeService.createProcessInstanceQuery().count());
assertEquals(1,getAllEventSubscriptions().size());
assertEquals(1,runtimeService.createProcessInstanceQuery().count());
assertEquals(2,runtimeService.createProcessInstanceQuery().count());
assertEquals(repositoryService.createProcessDefinitionQuery().deploymentId(deploymentId3).singleResult().getId(),eventSubscriptions.get(0).getProcessDefinitionId());
}