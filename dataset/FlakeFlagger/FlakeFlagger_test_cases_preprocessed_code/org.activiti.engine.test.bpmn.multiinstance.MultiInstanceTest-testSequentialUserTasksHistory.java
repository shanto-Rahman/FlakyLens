@Deployment(resources={"org/activiti/engine/test/bpmn/multiinstance/MultiInstanceTest.sequentialUserTasks.bpmn20.xml"}) public void testSequentialUserTasksHistory(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(4,historicTaskInstances.size());
assertNotNull(ht.getAssignee());
assertNotNull(ht.getStartTime());
assertNotNull(ht.getEndTime());
assertEquals(4,historicActivityInstances.size());
assertNotNull(hai.getActivityId());
assertNotNull(hai.getActivityName());
assertNotNull(hai.getStartTime());
assertNotNull(hai.getEndTime());
assertNotNull(hai.getAssignee());
}
}