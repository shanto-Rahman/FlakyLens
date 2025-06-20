@Deployment(resources={"org/activiti/engine/test/bpmn/multiinstance/MultiInstanceTest.testSequentialSubProcess.bpmn20.xml"}) public void testSequentialSubProcessHistory(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(4,onlySubProcessInstances.size());
assertEquals(4,historicInstances.size());
assertNotNull(hai.getStartTime());
assertNotNull(hai.getEndTime());
assertEquals(8,historicInstances.size());
assertNotNull(hai.getStartTime());
assertNotNull(hai.getEndTime());
}
}