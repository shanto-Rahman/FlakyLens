@Test public void testMigrateActivityToExclusiveGatewayStartInsideEmbeddedSubProcessDefaultFlow(){
  ProcessDefinition procDefOneTask=deployProcessDefinition("my deploy","org/flowable/engine/test/api/runtime/migration/one-task-simple-process.bpmn20.xml");
  ProcessDefinition procWithExcGtw=deployProcessDefinition("my deploy","org/flowable/engine/test/api/runtime/migration/exclusive-gateway-with-default-sequence-inside-embedded-subprocess.bpmn20.xml");
  ProcessInstance processInstance=runtimeService.startProcessInstanceById(procDefOneTask.getId());
  List<Execution> executions=runtimeService.createExecutionQuery().processInstanceId(processInstance.getId()).onlyChildExecutions().list();
  assertThat(executions).extracting(Execution::getActivityId).containsExactly("userTask1Id");
  assertThat(executions).extracting("processDefinitionId").containsOnly(procDefOneTask.getId());
  Task task=taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
  assertThat(task).extracting(Task::getTaskDefinitionKey).isEqualTo("userTask1Id");
  assertThat(task).extracting(Task::getProcessDefinitionId).isEqualTo(procDefOneTask.getId());
  ProcessInstanceMigrationBuilder processInstanceMigrationBuilder=processMigrationService.createProcessInstanceMigrationBuilder().migrateToProcessDefinition(procWithExcGtw.getId()).addActivityMigrationMapping(ActivityMigrationMapping.createMappingFor("userTask1Id","exclusiveGw"));
  ProcessInstanceMigrationValidationResult processInstanceMigrationValidationResult=processInstanceMigrationBuilder.validateMigration(processInstance.getId());
  assertThat(processInstanceMigrationValidationResult.isMigrationValid()).isTrue();
  processInstanceMigrationBuilder.migrate(processInstance.getId());
  executions=runtimeService.createExecutionQuery().processInstanceId(processInstance.getId()).onlyChildExecutions().list();
  assertThat(executions).extracting(Execution::getActivityId).containsExactly("theSubProcess","defaultFlowTask");
  task=taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
  assertThat(task).extracting(Task::getTaskDefinitionKey).isEqualTo("defaultFlowTask");
  if (HistoryTestHelper.isHistoryLevelAtLeast(HistoryLevel.ACTIVITY,processEngineConfiguration)) {
    checkActivityInstances(procWithExcGtw,processInstance,"userTask","userTask1Id","defaultFlowTask");
    checkActivityInstances(procWithExcGtw,processInstance,"subProcess","theSubProcess");
    checkActivityInstances(procWithExcGtw,processInstance,"exclusiveGateway","exclusiveGw");
    checkTaskInstance(procWithExcGtw,processInstance,"userTask1Id","defaultFlowTask");
  }
  completeProcessInstanceTasks(processInstance.getId());
  if (HistoryTestHelper.isHistoryLevelAtLeast(HistoryLevel.ACTIVITY,processEngineConfiguration)) {
    checkActivityInstances(procWithExcGtw,processInstance,"userTask","userTask1Id","defaultFlowTask","afterSubProcessTask");
    checkActivityInstances(procWithExcGtw,processInstance,"subProcess","theSubProcess");
    checkActivityInstances(procWithExcGtw,processInstance,"exclusiveGateway","exclusiveGw");
    checkTaskInstance(procWithExcGtw,processInstance,"userTask1Id","defaultFlowTask","afterSubProcessTask");
  }
  assertProcessEnded(processInstance.getId());
}
