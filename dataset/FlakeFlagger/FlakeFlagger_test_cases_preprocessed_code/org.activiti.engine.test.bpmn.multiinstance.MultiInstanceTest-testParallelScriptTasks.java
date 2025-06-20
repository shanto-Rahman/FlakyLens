@Deployment public void testParallelScriptTasks(){
assertEquals(2,executions.size());
if (execution.getId().equals(execution.getProcessInstanceId())) {
}
assertNotNull(processInstanceExecution);
assertNotNull(waitStateExecution);
assertEquals(45,sum);
}