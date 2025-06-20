@Deployment(resources={"org/activiti/engine/test/bpmn/multiinstance/MultiInstanceTest.testParallelUserTasks.bpmn20.xml"}) public void testParallelUserTasksHistory(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertNotNull(hi.getStartTime());
assertNotNull(hi.getEndTime());
assertEquals("My Task " + i,hi.getName());
assertEquals("kermit_" + i,hi.getAssignee());
assertEquals(3,historicActivityInstances.size());
assertNotNull(hai.getStartTime());
assertNotNull(hai.getEndTime());
assertNotNull(hai.getAssignee());
assertEquals("userTask",hai.getActivityType());
}
}