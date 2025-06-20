public void testCompleteTaskWithParametersNullParameters(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
}
assertNull(task);
}