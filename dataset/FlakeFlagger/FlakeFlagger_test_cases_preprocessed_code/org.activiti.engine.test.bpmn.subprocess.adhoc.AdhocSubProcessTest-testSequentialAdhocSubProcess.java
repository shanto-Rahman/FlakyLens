@Deployment public void testSequentialAdhocSubProcess(){
assertNotNull(execution);
assertEquals(2,enabledActivities.size());
assertEquals("Task in subprocess",subProcessTask.getName());
fail("exception expected because can only enable one activity in a sequential ad-hoc sub process");
assertEquals("Task2 in subprocess",subProcessTask.getName());
assertEquals("After task",afterTask.getName());
assertNull(runtimeService.createProcessInstanceQuery().processInstanceId(pi.getId()).singleResult());
}