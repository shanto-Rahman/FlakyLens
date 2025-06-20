@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testTaskAttachmentWithProcessInstanceId(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals("weatherforcast",attachment.getName());
assertEquals("temperatures and more",attachment.getDescription());
assertEquals("web page",attachment.getType());
assertEquals(processInstanceId,attachment.getProcessInstanceId());
assertNull(attachment.getTaskId());
assertEquals("http://weather.com",attachment.getUrl());
assertNull(taskService.getAttachmentContent(attachment.getId()));
}
}