@Test public void testMigrateActivityInsideExclusiveGatewayToActivityOutside(){
assertThat(executions).extracting(Execution::getActivityId).containsExactly("theTask2");
assertThat(executions).extracting("processDefinitionId").containsOnly(procWithExcGtw.getId());
assertThat(task).extracting(Task::getTaskDefinitionKey).isEqualTo("theTask2");
assertThat(task).extracting(Task::getProcessDefinitionId).isEqualTo(procWithExcGtw.getId());
assertThat(processInstanceMigrationValidationResult.isMigrationValid()).isTrue();
assertThat(executions).extracting(Execution::getActivityId).containsExactly("userTask1Id");
assertThat(task).extracting(Task::getTaskDefinitionKey).isEqualTo("userTask1Id");
if (HistoryTestHelper.isHistoryLevelAtLeast(HistoryLevel.ACTIVITY,processEngineConfiguration)) {
}
if (HistoryTestHelper.isHistoryLevelAtLeast(HistoryLevel.ACTIVITY,processEngineConfiguration)) {
}
}