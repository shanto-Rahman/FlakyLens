public void testTaskInfoQuery(){
assertEquals(3,taskInfos.size());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals(3,taskInfos.size());
}
}