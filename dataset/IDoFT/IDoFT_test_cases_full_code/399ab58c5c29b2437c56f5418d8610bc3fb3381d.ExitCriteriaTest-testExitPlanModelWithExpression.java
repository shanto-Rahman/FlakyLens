@Test @CmmnDeployment public void testExitPlanModelWithExpression(){
  CaseInstance caseInstance=cmmnRuntimeService.createCaseInstanceBuilder().caseDefinitionKey("minimalCase").start();
  Task task=cmmnTaskService.createTaskQuery().caseInstanceId(caseInstance.getId()).singleResult();
  cmmnTaskService.complete(task.getId());
  assertCaseInstanceEnded(caseInstance);
}
