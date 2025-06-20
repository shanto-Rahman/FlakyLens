@Test @Deployment public void testSubProcessWithTimer(){
assertEquals(2,executionList.size());
if (execution.getId().equals(execution.getProcessInstanceId())) {
assertNull(execution.getActivityId());
assertTrue(execution.getId().equals(execution.getProcessInstanceId()) == false);
assertEquals("theTask1",execution.getActivityId());
}
assertNotNull(rootProcessInstance);
assertNotNull(childExecution);
assertEquals(childExecution.getId(),task.getExecutionId());
assertEquals(4,executionList.size());
assertEquals("subTask",task.getTaskDefinitionKey());
assertEquals("subTask",subTaskExecution.getActivityId());
assertEquals("subProcess",subProcessExecution.getActivityId());
assertEquals(rootProcessInstance.getId(),subProcessExecution.getParentId());
assertEquals(2,executionList.size());
assertTrue(childExecution.getId().equals(task.getExecutionId()) == false);
assertEquals("theTask2",finalTaskExecution.getActivityId());
assertEquals(rootProcessInstance.getId(),finalTaskExecution.getParentId());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(8,historicActivities.size());
if ("theStart".equalsIgnoreCase(activityId) || "theTask1".equalsIgnoreCase(activityId)) {
assertEquals(childExecution.getId(),historicActivityInstance.getExecutionId());
if ("theTask2".equalsIgnoreCase(activityId) || "theEnd".equalsIgnoreCase(activityId)) {
assertEquals(finalTaskExecution.getId(),historicActivityInstance.getExecutionId());
if ("subStart".equalsIgnoreCase(activityId) || "subTask".equalsIgnoreCase(activityId) || "subEnd".equalsIgnoreCase(activityId)) {
assertEquals(subTaskExecution.getId(),historicActivityInstance.getExecutionId());
if ("subProcess".equalsIgnoreCase(activityId)) {
assertEquals(subProcessExecution.getId(),historicActivityInstance.getExecutionId());
}
}
}
}
assertEquals(0,activityIds.size());
}
}