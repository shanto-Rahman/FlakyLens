@Test public void testMigrateActivityToExclusiveGatewayStartInsideEmbeddedSubProcess(){
assertThat(executions).extracting(Execution::getActivityId).containsExactly("userTask1Id");
assertThat(executions).extracting("processDefinitionId").containsOnly(procDefOneTask.getId());
assertThat(task).extracting(Task::getTaskDefinitionKey).isEqualTo("userTask1Id");
assertThat(task).extracting(Task::getProcessDefinitionId).isEqualTo(procDefOneTask.getId());
assertThat(processInstanceMigrationValidationResult.isMigrationValid()).isTrue();
assertThat(executions).extracting(Execution::getActivityId).containsExactly("theSubProcess","theTask1");
assertThat(task).extracting(Task::getTaskDefinitionKey).isEqualTo("theTask1");
if (HistoryTestHelper.isHistoryLevelAtLeast(HistoryLevel.ACTIVITY,processEngineConfiguration)) {
}
if (HistoryTestHelper.isHistoryLevelAtLeast(HistoryLevel.ACTIVITY,processEngineConfiguration)) {
}
}