public void testSaveTaskAttachment(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals("UpdatedName",attachment.getName());
assertEquals(0,taskService.getTaskComments(taskId).size());
assertEquals(1,historyService.createHistoricTaskInstanceQuery().taskId(taskId).list().size());
}
}