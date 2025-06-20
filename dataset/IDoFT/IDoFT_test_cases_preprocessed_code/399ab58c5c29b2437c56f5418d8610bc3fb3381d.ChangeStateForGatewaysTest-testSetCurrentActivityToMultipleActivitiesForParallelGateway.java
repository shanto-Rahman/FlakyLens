@Test @Deployment(resources={"org/flowable/engine/test/api/parallelTask.bpmn20.xml"}) public void testSetCurrentActivityToMultipleActivitiesForParallelGateway(){
assertEquals("taskBefore",task.getTaskDefinitionKey());
assertEquals(2,tasks.size());
assertEquals(2,executions.size());
assertTrue(executionsByActivity.containsKey("task1"));
assertTrue(executionsByActivity.containsKey("task2"));
assertFalse(executionsByActivity.containsKey("parallelJoin"));
if (task1.isPresent()) {
}
assertTrue(iterator.hasNext());
assertEquals(FlowableEngineEventType.ACTIVITY_CANCELLED,event.getType());
assertEquals("taskBefore",((FlowableActivityEvent)event).getActivityId());
assertTrue(iterator.hasNext());
assertEquals(FlowableEngineEventType.ACTIVITY_STARTED,event.getType());
assertEquals("task1",((FlowableActivityEvent)event).getActivityId());
assertTrue(iterator.hasNext());
assertEquals(FlowableEngineEventType.ACTIVITY_STARTED,event.getType());
assertEquals("task2",((FlowableActivityEvent)event).getActivityId());
assertTrue(!iterator.hasNext());
assertEquals(1,tasks.size());
assertEquals(2,executions.size());
assertFalse(executionsByActivity.containsKey("task1"));
assertTrue(executionsByActivity.containsKey("task2"));
assertTrue(executionsByActivity.containsKey("parallelJoin"));
assertFalse(((ExecutionEntity)executionsByActivity.get("parallelJoin").get(0)).isActive());
assertEquals("taskAfter",task.getTaskDefinitionKey());
}