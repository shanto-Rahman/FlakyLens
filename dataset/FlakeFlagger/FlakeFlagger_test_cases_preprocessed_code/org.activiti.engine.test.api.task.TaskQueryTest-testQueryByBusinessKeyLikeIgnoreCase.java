@Deployment(resources={"org/activiti/engine/test/api/task/TaskQueryTest.testProcessDefinition.bpmn20.xml"}) public void testQueryByBusinessKeyLikeIgnoreCase(){
assertEquals(3,taskService.createTaskQuery().processInstanceBusinessKeyLikeIgnoreCase("%key%").count());
assertEquals(3,taskService.createTaskQuery().processInstanceBusinessKeyLikeIgnoreCase("%KEY%").count());
assertEquals(3,taskService.createTaskQuery().processInstanceBusinessKeyLikeIgnoreCase("%EY%").count());
assertEquals(2,taskService.createTaskQuery().processInstanceBusinessKeyLikeIgnoreCase("%business%").count());
assertEquals(2,taskService.createTaskQuery().processInstanceBusinessKeyLikeIgnoreCase("business%").count());
assertEquals(0,taskService.createTaskQuery().processInstanceBusinessKeyLikeIgnoreCase("%doesnotexist%").count());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals(3,historyService.createHistoricTaskInstanceQuery().processInstanceBusinessKeyLikeIgnoreCase("%key%").count());
assertEquals(3,historyService.createHistoricTaskInstanceQuery().processInstanceBusinessKeyLikeIgnoreCase("%KEY%").count());
assertEquals(3,historyService.createHistoricTaskInstanceQuery().processInstanceBusinessKeyLikeIgnoreCase("%EY%").count());
assertEquals(2,historyService.createHistoricTaskInstanceQuery().processInstanceBusinessKeyLikeIgnoreCase("%business%").count());
assertEquals(2,historyService.createHistoricTaskInstanceQuery().processInstanceBusinessKeyLikeIgnoreCase("business%").count());
assertEquals(0,historyService.createHistoricTaskInstanceQuery().processInstanceBusinessKeyLikeIgnoreCase("%doesnotexist%").count());
}
}