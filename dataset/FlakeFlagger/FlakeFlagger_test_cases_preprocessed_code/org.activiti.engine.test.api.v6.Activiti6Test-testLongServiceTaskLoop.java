@Test @org.activiti.engine.test.Deployment public void testLongServiceTaskLoop(){
assertNotNull(processInstance);
assertTrue(processInstance.isEnded());
assertEquals(maxCount,CountingServiceTaskTestDelegate.CALL_COUNT.get());
assertEquals(0,runtimeService.createExecutionQuery().count());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals(maxCount,historyService.createHistoricActivityInstanceQuery().processInstanceId(processInstance.getId()).activityId("serviceTask").count());
}
}