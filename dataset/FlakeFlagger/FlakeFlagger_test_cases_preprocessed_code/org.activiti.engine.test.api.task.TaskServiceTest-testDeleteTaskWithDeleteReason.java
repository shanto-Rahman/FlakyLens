public void testDeleteTaskWithDeleteReason(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertNotNull(task.getId());
assertNotNull(historicTaskInstance);
assertEquals("deleted for testing purposes",historicTaskInstance.getDeleteReason());
}
}