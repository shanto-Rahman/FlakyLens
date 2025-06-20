@Deployment public void testHistoricActivityInstanceEndTimes(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals(21,historicActivityInstances.size());
Assert.assertTrue(historicActivityInstance.getStartTime() != null);
Assert.assertTrue(historicActivityInstance.getEndTime() != null);
}
}