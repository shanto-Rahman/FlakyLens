@Test @CmmnDeployment(resources={"org/flowable/cmmn/test/runtime/CaseTaskTest.terminateAvailableCaseTask.cmmn","org/flowable/cmmn/test/runtime/oneHumanTaskCase.cmmn"}) public void testTerminateAvailableCaseTask(){
  CaseInstance caseInstance=cmmnRuntimeService.createCaseInstanceBuilder().caseDefinitionKey("terminateAvailableCaseTask").start();
  PlanItemInstance planItemInstance=cmmnRuntimeService.createPlanItemInstanceQuery().caseInstanceId(caseInstance.getId()).planItemDefinitionType(PlanItemDefinitionType.CASE_TASK).planItemInstanceStateAvailable().singleResult();
  assertEquals("myCase",planItemInstance.getName());
  UserEventListenerInstance userEventListenerInstance=cmmnRuntimeService.createUserEventListenerInstanceQuery().caseInstanceId(caseInstance.getId()).singleResult();
  cmmnRuntimeService.completeUserEventListenerInstance(userEventListenerInstance.getId());
  assertCaseInstanceEnded(caseInstance);
}
