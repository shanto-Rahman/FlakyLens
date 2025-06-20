public void testQueryMultipleAndAndMultipleOr(){
assertEquals(4,taskService.createTaskQuery().taskInvolvedUser("user1").taskInvolvedGroupsIn(andGroup).or().taskInvolvedGroupsIn(orGroup).taskInvolvedUser("user2").endOr().count());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals(4,historyService.createHistoricTaskInstanceQuery().taskInvolvedUser("user1").taskInvolvedGroupsIn(andGroup).or().taskInvolvedGroupsIn(orGroup).taskInvolvedUser("user2").endOr().count());
}
if (task.getExecutionId() == null) {
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
}
}
}