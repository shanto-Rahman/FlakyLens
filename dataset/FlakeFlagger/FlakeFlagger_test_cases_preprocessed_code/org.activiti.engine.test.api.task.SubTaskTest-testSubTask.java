public void testSubTask(){
assertTrue(taskService.getSubTasks(subTaskId).isEmpty());
assertTrue(historyService.createHistoricTaskInstanceQuery().taskParentTaskId(subTaskId).list().isEmpty());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals(expectedSubTaskNames,subTaskNames);
assertEquals(expectedSubTaskNames,subTaskNames);
}
}