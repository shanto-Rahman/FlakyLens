@Deployment(resources={TEST_PROCESS_NESTED_SUB_EXECUTIONS}) public void testSetProcessDefinitionVersionSubExecutionsNested(){
assertEquals(2,taskService.createTaskQuery().count());
assertEquals(2,repositoryService.createProcessDefinitionQuery().count());
assertEquals(newProcessDefinition.getId(),((ExecutionEntity)execution).getProcessDefinitionId());
}