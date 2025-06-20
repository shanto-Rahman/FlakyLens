@SuppressWarnings("unchecked") public void testCompleteTaskWithParametersEmptyParameters(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
}
assertNull(task);
}