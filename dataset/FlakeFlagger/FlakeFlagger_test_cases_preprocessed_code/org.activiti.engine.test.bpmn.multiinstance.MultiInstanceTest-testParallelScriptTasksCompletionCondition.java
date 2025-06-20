@Deployment public void testParallelScriptTasksCompletionCondition(){
assertNotNull(waitStateExecution);
assertEquals(2,sum);
}