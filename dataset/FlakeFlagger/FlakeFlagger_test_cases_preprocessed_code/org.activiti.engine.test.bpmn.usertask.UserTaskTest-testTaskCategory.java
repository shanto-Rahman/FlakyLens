@Deployment public void testTaskCategory(){
assertEquals(testCategory,task.getCategory());
assertEquals("Task with category",taskService.createTaskQuery().taskCategory(testCategory).singleResult().getName());
assertTrue(taskService.createTaskQuery().taskCategory("Does not exist").count() == 0);
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals(testCategory,historicTaskInstance.getCategory());
assertEquals("Task with category",historyService.createHistoricTaskInstanceQuery().taskCategory(testCategory).singleResult().getName());
assertTrue(historyService.createHistoricTaskInstanceQuery().taskCategory("Does not exist").count() == 0);
assertEquals(newCategory,task.getCategory());
assertEquals("Task with category",taskService.createTaskQuery().taskCategory(newCategory).singleResult().getName());
assertTrue(taskService.createTaskQuery().taskCategory(testCategory).count() == 0);
assertEquals(newCategory,historicTaskInstance.getCategory());
assertEquals("Task with category",historyService.createHistoricTaskInstanceQuery().taskCategory(newCategory).singleResult().getName());
assertTrue(historyService.createHistoricTaskInstanceQuery().taskCategory(testCategory).count() == 0);
}
}