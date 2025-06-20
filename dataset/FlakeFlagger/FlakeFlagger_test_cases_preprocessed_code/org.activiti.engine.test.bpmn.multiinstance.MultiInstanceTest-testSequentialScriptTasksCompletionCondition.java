@Deployment public void testSequentialScriptTasksCompletionCondition(){
assertEquals(2,executions.size());
if (execution.getId().equals(execution.getProcessInstanceId())) {
}
assertNotNull(processInstanceExecution);
assertNotNull(waitStateExecution);
assertEquals(5,sum);
}