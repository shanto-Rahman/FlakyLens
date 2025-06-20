@Deployment(resources={"org/activiti/engine/test/bpmn/multiinstance/MultiInstanceTest.testSequentialScriptTasks.bpmn20.xml"}) public void testSequentialScriptTasksHistory(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(7,historicInstances.size());
assertEquals("scriptTask",hai.getActivityType());
assertNotNull(hai.getStartTime());
assertNotNull(hai.getEndTime());
}
}