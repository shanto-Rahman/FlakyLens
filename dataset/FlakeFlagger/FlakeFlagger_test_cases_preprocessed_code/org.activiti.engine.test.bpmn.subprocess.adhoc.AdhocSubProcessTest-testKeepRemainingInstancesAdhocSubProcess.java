@Deployment public void testKeepRemainingInstancesAdhocSubProcess(){
assertNotNull(execution);
assertEquals(2,enabledActivities.size());
assertEquals("Task in subprocess",subProcessTask.getName());
assertEquals(2,tasks.size());
assertEquals("Task2 in subprocess",subProcessTask.getName());
assertEquals("After task",afterTask.getName());
assertNull(runtimeService.createProcessInstanceQuery().processInstanceId(pi.getId()).singleResult());
}