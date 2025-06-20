@Deployment(resources={"org/activiti/engine/test/bpmn/multiinstance/MultiInstanceTest.testParallelScriptTasks.bpmn20.xml"}) public void testParallelScriptTasksHistory(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(4,historicActivityInstances.size());
assertNotNull(hai.getStartTime());
assertNotNull(hai.getEndTime());
}
}