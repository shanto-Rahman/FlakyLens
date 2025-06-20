@Deployment public void testMultipleProcessInstancesMergedBug(){
assertNotNull(taskCInPi1);
assertNotNull(taskBInPi2);
assertEquals(2,getInactiveExecutionsInActivityId("inclusiveGw").size());
assertEquals(1,getInactiveExecutionsInActivityId("inclusiveGw").size());
assertEquals(1L,taskService.createTaskQuery().taskName("After Merge").count());
assertEquals(0L,runtimeService.createProcessInstanceQuery().count());
}