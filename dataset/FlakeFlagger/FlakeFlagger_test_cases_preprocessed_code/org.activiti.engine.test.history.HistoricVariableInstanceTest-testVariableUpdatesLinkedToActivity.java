@Deployment(resources={"org/activiti/standalone/history/FullHistoryTest.testVariableUpdatesAreLinkedToActivity.bpmn20.xml"}) public void testVariableUpdatesLinkedToActivity() throws Exception {
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.FULL)) {
assertEquals(2,updates.size());
assertNotNull(update1.getActivityInstanceId());
assertNotNull(update1.getExecutionId());
assertEquals("usertask1",historicActivityInstance1.getActivityId());
assertNotNull(update2.getActivityInstanceId());
assertEquals("usertask2",historicActivityInstance2.getActivityId());
assertFalse(historicActivityInstance2.getExecutionId().equals(update2.getExecutionId()));
}
}