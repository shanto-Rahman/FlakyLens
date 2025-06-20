@Deployment public void testFlowsInAdhocSubProcess(){
assertNotNull(execution);
assertEquals(2,enabledActivities.size());
assertEquals("Task in subprocess",subProcessTask.getName());
fail("exception expected because can only enable one activity in a sequential ad-hoc sub process");
assertEquals("The next task",subProcessTask.getName());
assertEquals("After task",afterTask.getName());
assertNull(runtimeService.createProcessInstanceQuery().processInstanceId(pi.getId()).singleResult());
}