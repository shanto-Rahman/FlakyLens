@Deployment public void testCompensateMiSubprocessVariableSnapshots(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(5,historyService.createHistoricActivityInstanceQuery().activityId("undoBookHotel").count());
}
}