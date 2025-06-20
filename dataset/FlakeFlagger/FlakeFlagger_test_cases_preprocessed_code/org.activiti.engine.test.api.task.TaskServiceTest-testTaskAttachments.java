public void testTaskAttachments(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals("weatherforcast",attachment.getName());
assertEquals("temperatures and more",attachment.getDescription());
assertEquals("web page",attachment.getType());
assertEquals(taskId,attachment.getTaskId());
assertNull(attachment.getProcessInstanceId());
assertEquals("http://weather.com",attachment.getUrl());
assertNull(taskService.getAttachmentContent(attachment.getId()));
assertEquals(0,taskService.getTaskComments(taskId).size());
assertEquals(1,historyService.createHistoricTaskInstanceQuery().taskId(taskId).list().size());
}
}