@Test @CmmnDeployment public void testRepeatingRuleUserEventListener(){
assertEquals(0L,cmmnTaskService.createTaskQuery().count());
assertEquals(PlanItemInstanceState.AVAILABLE,userEventListenerInstance.getState());
if (i == 2) {
}
assertEquals(3,cmmnTaskService.createTaskQuery().count());
}