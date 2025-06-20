@Deployment public void testHistoricTaskInstanceUpdate(){
assertEquals(1,historyService.createHistoricTaskInstanceQuery().count());
assertEquals("Updated name",historicTaskInstance.getName());
assertEquals("Updated description",historicTaskInstance.getDescription());
assertEquals("gonzo",historicTaskInstance.getAssignee());
assertEquals("task",historicTaskInstance.getTaskDefinitionKey());
assertEquals(1,historyService.createHistoricTaskInstanceQuery().processInstanceId(secondInstance.getId()).count());
assertNull(historicTaskInstance.getName());
assertNull(historicTaskInstance.getDescription());
assertNull(historicTaskInstance.getAssignee());
}