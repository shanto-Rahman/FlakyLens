@Deployment(resources={"org/activiti/engine/test/bpmn/multiinstance/MultiInstanceTest.testParallelSubProcess.bpmn20.xml"}) public void testParallelSubProcessHistory(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(2,historicActivityInstances.size());
assertNotNull(hai.getStartTime());
assertNotNull(hai.getEndTime());
}
}