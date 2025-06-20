@Deployment public void testSimpleAdhocSubProcess(){
assertNotNull(execution);
assertEquals(2,enabledActivities.size());
assertNotNull(newTaskExecution);
assertNotNull(newTaskExecution.getId());
assertEquals("Task in subprocess",subProcessTask.getName());
assertEquals(2,enabledActivities.size());
assertEquals("After task",afterTask.getName());
assertNull(runtimeService.createProcessInstanceQuery().processInstanceId(pi.getId()).singleResult());
}