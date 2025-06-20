@Deployment(resources={TEST_PROCESS_USER_TASK_V1}) public void testSetProcessDefinitionVersionWithWithTask(){
assertEquals(1,taskService.createTaskQuery().processInstanceId(pi.getId()).count());
assertEquals(2,repositoryService.createProcessDefinitionQuery().processDefinitionKey("userTask").count());
assertEquals(newProcessDefinition.getId(),task.getProcessDefinitionId());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(newProcessDefinition.getId(),historicTask.getProcessDefinitionId());
}
}