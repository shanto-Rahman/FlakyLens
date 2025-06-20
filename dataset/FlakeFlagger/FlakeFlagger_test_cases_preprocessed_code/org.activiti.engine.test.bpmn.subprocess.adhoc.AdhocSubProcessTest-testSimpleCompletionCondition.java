@Deployment public void testSimpleCompletionCondition(){
assertNotNull(execution);
assertEquals(2,enabledActivities.size());
assertNotNull(newTaskExecution);
assertNotNull(newTaskExecution.getId());
assertEquals("Task in subprocess",subProcessTask.getName());
assertEquals(2,enabledActivities.size());
assertEquals("Task2 in subprocess",subProcessTask.getName());
assertEquals("After task",afterTask.getName());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals(3,historicTasks.size());
assertTrue(taskDefinitionKeys.contains("subProcessTask"));
assertTrue(taskDefinitionKeys.contains("subProcessTask2"));
assertTrue(taskDefinitionKeys.contains("afterTask"));
}
assertNull(runtimeService.createProcessInstanceQuery().processInstanceId(pi.getId()).singleResult());
}