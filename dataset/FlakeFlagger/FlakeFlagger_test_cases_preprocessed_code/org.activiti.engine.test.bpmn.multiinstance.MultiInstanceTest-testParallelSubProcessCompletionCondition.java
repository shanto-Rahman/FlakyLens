@Deployment public void testParallelSubProcessCompletionCondition(){
assertEquals(4,tasks.size());
assertEquals(2,subProcessTasks1.size());
assertEquals(2,subProcessTasks2.size());
if (toFindExecution.getParentId().equals(parentExecutionId)) {
}
assertNotNull(subProcessTask2);
}