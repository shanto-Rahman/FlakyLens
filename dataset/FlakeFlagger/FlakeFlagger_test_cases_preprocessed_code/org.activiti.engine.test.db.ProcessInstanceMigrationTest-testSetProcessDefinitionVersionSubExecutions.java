@Deployment(resources={TEST_PROCESS_WITH_PARALLEL_GATEWAY}) public void testSetProcessDefinitionVersionSubExecutions(){
assertEquals(2,taskService.createTaskQuery().count());
assertEquals(2,repositoryService.createProcessDefinitionQuery().count());
assertEquals(newProcessDefinition.getId(),((ExecutionEntity)execution).getProcessDefinitionId());
}