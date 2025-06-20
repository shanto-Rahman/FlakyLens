@Deployment public void testCompensateWithSubprocess(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertNotNull(historicActivityInstance.getEndTime());
}
assertNotNull(compensationTask1);
assertNotNull(compensationTask2);
assertNotNull(compensationTask3);
}