@Test @CmmnDeployment public void testRepeatingRuleUserEventListener(){
  CaseInstance caseInstance=cmmnRuntimeService.createCaseInstanceBuilder().caseDefinitionKey("testRepeatingUserEventListener").variable("keepGoing",true).start();
  assertEquals(0L,cmmnTaskService.createTaskQuery().count());
  for (int i=0; i < 3; i++) {
    UserEventListenerInstance userEventListenerInstance=cmmnRuntimeService.createUserEventListenerInstanceQuery().caseInstanceId(caseInstance.getId()).singleResult();
    assertEquals(PlanItemInstanceState.AVAILABLE,userEventListenerInstance.getState());
    if (i == 2) {
      cmmnRuntimeService.setVariable(caseInstance.getId(),"keepGoing",false);
    }
    cmmnRuntimeService.completeGenericEventListenerInstance(userEventListenerInstance.getId());
  }
  assertEquals(3,cmmnTaskService.createTaskQuery().count());
}
