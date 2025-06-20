@Test @CmmnDeployment public void testExitAvailableProcessTaskThroughExitSentryOnStage(){
assertEquals("theProcess",planItemInstance.getName());
assertNull(cmmnTaskService.createTaskQuery().taskName("task2").singleResult());
assertNotNull(cmmnTaskService.createTaskQuery().taskName("task2").singleResult());
assertNull(cmmnRuntimeService.createPlanItemInstanceQuery().planItemInstanceStateAvailable().planItemDefinitionType(PlanItemDefinitionType.PROCESS_TASK).singleResult());
}