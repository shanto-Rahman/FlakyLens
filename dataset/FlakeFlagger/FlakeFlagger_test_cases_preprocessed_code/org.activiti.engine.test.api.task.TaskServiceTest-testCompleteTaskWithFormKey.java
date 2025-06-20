@Deployment(resources={"org/activiti/engine/test/api/oneTaskWithFormKeyProcess.bpmn20.xml"}) public void testCompleteTaskWithFormKey(){
assertEquals("my task",task.getName());
assertEquals("myFormKey",task.getFormKey());
assertEquals("myAssignee",task.getAssignee());
assertEquals("myOwner",task.getOwner());
assertEquals("myCategory",task.getCategory());
assertEquals(60,task.getPriority());
assertNotNull(task.getDueDate());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals("my task",historicTask.getName());
assertEquals("myFormKey",historicTask.getFormKey());
assertEquals("myAssignee",historicTask.getAssignee());
assertEquals("myOwner",historicTask.getOwner());
assertEquals("myCategory",historicTask.getCategory());
assertEquals(60,historicTask.getPriority());
assertNotNull(historicTask.getDueDate());
}
}