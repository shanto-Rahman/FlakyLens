@Deployment public void testDefaultSequenceFlowOnTask(){
assertNotNull(runtimeService.createExecutionQuery().processInstanceId(procId).activityId("task2").singleResult());
assertNotNull(runtimeService.createExecutionQuery().processInstanceId(procId).activityId("task3").singleResult());
assertNotNull(runtimeService.createExecutionQuery().processInstanceId(procId).activityId("task1").singleResult());
}