@Test @CmmnDeployment public void testExitAvailableProcessTaskThroughExitSentryOnStage(){
  CaseInstance caseInstance=cmmnRuntimeService.createCaseInstanceBuilder().caseDefinitionKey("testExitAvailableProcessTaskThroughExitSentryOnStage").start();
  PlanItemInstance planItemInstance=cmmnRuntimeService.createPlanItemInstanceQuery().planItemInstanceStateAvailable().planItemDefinitionType(PlanItemDefinitionType.PROCESS_TASK).singleResult();
  assertEquals("theProcess",planItemInstance.getName());
  assertNull(cmmnTaskService.createTaskQuery().taskName("task2").singleResult());
  UserEventListenerInstance userEventListenerInstance=cmmnRuntimeService.createUserEventListenerInstanceQuery().caseInstanceId(caseInstance.getId()).singleResult();
  cmmnRuntimeService.completeUserEventListenerInstance(userEventListenerInstance.getId());
  assertNotNull(cmmnTaskService.createTaskQuery().taskName("task2").singleResult());
  assertNull(cmmnRuntimeService.createPlanItemInstanceQuery().planItemInstanceStateAvailable().planItemDefinitionType(PlanItemDefinitionType.PROCESS_TASK).singleResult());
}
