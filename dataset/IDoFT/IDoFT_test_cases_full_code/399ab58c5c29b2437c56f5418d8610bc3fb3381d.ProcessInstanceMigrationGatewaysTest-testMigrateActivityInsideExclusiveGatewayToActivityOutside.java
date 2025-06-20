@Test public void testMigrateActivityInsideExclusiveGatewayToActivityOutside(){
  ProcessDefinition procWithExcGtw=deployProcessDefinition("my deploy","org/flowable/engine/test/api/runtime/migration/exclusive-gateway-with-default-sequence.bpmn20.xml");
  ProcessDefinition procDefOneTask=deployProcessDefinition("my deploy","org/flowable/engine/test/api/runtime/migration/one-task-simple-process.bpmn20.xml");
  Map<String,Object> gtwCondition=Collections.singletonMap("input",Integer.valueOf(2));
  ProcessInstance processInstance=runtimeService.startProcessInstanceById(procWithExcGtw.getId(),gtwCondition);
  List<Execution> executions=runtimeService.createExecutionQuery().processInstanceId(processInstance.getId()).onlyChildExecutions().list();
  assertThat(executions).extracting(Execution::getActivityId).containsExactly("theTask2");
  assertThat(executions).extracting("processDefinitionId").containsOnly(procWithExcGtw.getId());
  Task task=taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
  assertThat(task).extracting(Task::getTaskDefinitionKey).isEqualTo("theTask2");
  assertThat(task).extracting(Task::getProcessDefinitionId).isEqualTo(procWithExcGtw.getId());
  ProcessInstanceMigrationBuilder processInstanceMigrationBuilder=processMigrationService.createProcessInstanceMigrationBuilder().migrateToProcessDefinition(procDefOneTask.getId()).addActivityMigrationMapping(ActivityMigrationMapping.createMappingFor("theTask2","userTask1Id"));
  ProcessInstanceMigrationValidationResult processInstanceMigrationValidationResult=processInstanceMigrationBuilder.validateMigration(processInstance.getId());
  assertThat(processInstanceMigrationValidationResult.isMigrationValid()).isTrue();
  processInstanceMigrationBuilder.migrate(processInstance.getId());
  executions=runtimeService.createExecutionQuery().processInstanceId(processInstance.getId()).onlyChildExecutions().list();
  assertThat(executions).extracting(Execution::getActivityId).containsExactly("userTask1Id");
  task=taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
  assertThat(task).extracting(Task::getTaskDefinitionKey).isEqualTo("userTask1Id");
  if (HistoryTestHelper.isHistoryLevelAtLeast(HistoryLevel.ACTIVITY,processEngineConfiguration)) {
    checkActivityInstances(procDefOneTask,processInstance,"userTask","userTask1Id");
    checkActivityInstances(procDefOneTask,processInstance,"exclusiveGateway","exclusiveGw");
    checkTaskInstance(procDefOneTask,processInstance,"userTask1Id");
  }
  completeProcessInstanceTasks(processInstance.getId());
  if (HistoryTestHelper.isHistoryLevelAtLeast(HistoryLevel.ACTIVITY,processEngineConfiguration)) {
    checkActivityInstances(procDefOneTask,processInstance,"userTask","userTask1Id");
    checkActivityInstances(procDefOneTask,processInstance,"exclusiveGateway","exclusiveGw");
    checkTaskInstance(procDefOneTask,processInstance,"userTask1Id");
  }
  assertProcessEnded(processInstance.getId());
}
