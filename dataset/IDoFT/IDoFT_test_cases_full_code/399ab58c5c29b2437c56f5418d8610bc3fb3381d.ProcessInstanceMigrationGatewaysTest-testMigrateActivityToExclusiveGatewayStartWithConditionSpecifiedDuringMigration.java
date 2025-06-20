@Test public void testMigrateActivityToExclusiveGatewayStartWithConditionSpecifiedDuringMigration(){
  ProcessDefinition procDefOneTask=deployProcessDefinition("my deploy","org/flowable/engine/test/api/runtime/migration/one-task-simple-process.bpmn20.xml");
  ProcessDefinition procWithExcGtw=deployProcessDefinition("my deploy","org/flowable/engine/test/api/runtime/migration/exclusive-gateway-with-default-sequence.bpmn20.xml");
  ProcessInstance processInstance=runtimeService.startProcessInstanceById(procDefOneTask.getId());
  List<Execution> executions=runtimeService.createExecutionQuery().processInstanceId(processInstance.getId()).onlyChildExecutions().list();
  assertThat(executions).extracting(Execution::getActivityId).containsExactly("userTask1Id");
  assertThat(executions).extracting("processDefinitionId").containsOnly(procDefOneTask.getId());
  Task task=taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
  assertThat(task).extracting(Task::getTaskDefinitionKey).isEqualTo("userTask1Id");
  assertThat(task).extracting(Task::getProcessDefinitionId).isEqualTo(procDefOneTask.getId());
  ProcessInstanceMigrationBuilder processInstanceMigrationBuilder=processMigrationService.createProcessInstanceMigrationBuilder().migrateToProcessDefinition(procWithExcGtw.getId()).addActivityMigrationMapping(ActivityMigrationMapping.createMappingFor("userTask1Id","exclusiveGw").withLocalVariable("input",Integer.valueOf(1)));
  ProcessInstanceMigrationValidationResult processInstanceMigrationValidationResult=processInstanceMigrationBuilder.validateMigration(processInstance.getId());
  assertThat(processInstanceMigrationValidationResult.isMigrationValid()).isTrue();
  processInstanceMigrationBuilder.migrate(processInstance.getId());
  executions=runtimeService.createExecutionQuery().processInstanceId(processInstance.getId()).onlyChildExecutions().list();
  assertThat(executions).extracting(Execution::getActivityId).containsExactly("theTask1");
  task=taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
  assertThat(task).extracting(Task::getTaskDefinitionKey).isEqualTo("theTask1");
  if (HistoryTestHelper.isHistoryLevelAtLeast(HistoryLevel.ACTIVITY,processEngineConfiguration)) {
    checkActivityInstances(procWithExcGtw,processInstance,"userTask","userTask1Id","theTask1");
    checkActivityInstances(procWithExcGtw,processInstance,"exclusiveGateway","exclusiveGw");
    checkTaskInstance(procWithExcGtw,processInstance,"userTask1Id","theTask1");
  }
  completeProcessInstanceTasks(processInstance.getId());
  assertProcessEnded(processInstance.getId());
  if (HistoryTestHelper.isHistoryLevelAtLeast(HistoryLevel.ACTIVITY,processEngineConfiguration)) {
    checkActivityInstances(procWithExcGtw,processInstance,"userTask","userTask1Id","theTask1");
    checkActivityInstances(procWithExcGtw,processInstance,"exclusiveGateway","exclusiveGw");
    checkTaskInstance(procWithExcGtw,processInstance,"userTask1Id","theTask1");
  }
}
