@Deployment public void testParallelFlowsWithKeepRemainingInstancesAdhocSubProcess(){
assertNotNull(execution);
assertEquals(3,enabledActivities.size());
assertEquals("Task in subprocess",subProcessTask.getName());
assertEquals("Task2 in subprocess",subProcessTask2.getName());
assertEquals("The next task2",subProcessTask2.getName());
assertEquals(3,tasks.size());
assertEquals(3,tasks.size());
assertEquals("The next task",subProcessTask.getName());
assertEquals(2,tasks.size());
assertEquals("Task3 in subprocess",subProcessTask3.getName());
assertEquals("After task",afterTask.getName());
assertNull(runtimeService.createProcessInstanceQuery().processInstanceId(pi.getId()).singleResult());
}