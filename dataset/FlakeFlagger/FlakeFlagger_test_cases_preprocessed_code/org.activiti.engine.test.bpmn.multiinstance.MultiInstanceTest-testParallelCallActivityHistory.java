@Deployment(resources={"org/activiti/engine/test/bpmn/multiinstance/MultiInstanceTest.testParallelCallActivity.bpmn20.xml","org/activiti/engine/test/bpmn/multiinstance/MultiInstanceTest.externalSubProcess.bpmn20.xml"}) public void testParallelCallActivityHistory(){
assertEquals(12,tasks.size());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(7,historicProcessInstances.size());
assertNotNull(hpi.getStartTime());
assertNotNull(hpi.getEndTime());
assertEquals(12,historicTaskInstances.size());
assertNotNull(hti.getStartTime());
assertNotNull(hti.getEndTime());
assertNotNull(hti.getAssignee());
assertNull(hti.getDeleteReason());
assertEquals(6,historicActivityInstances.size());
assertNotNull(hai.getStartTime());
assertNotNull(hai.getEndTime());
}
}