public void testSubTaskDeleteOnProcessInstanceDelete(){
assertEquals(3,tasks.size());
assertEquals(0,tasks.size());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(3,historicTasks.size());
assertEquals(0,historicTasks.size());
}
}