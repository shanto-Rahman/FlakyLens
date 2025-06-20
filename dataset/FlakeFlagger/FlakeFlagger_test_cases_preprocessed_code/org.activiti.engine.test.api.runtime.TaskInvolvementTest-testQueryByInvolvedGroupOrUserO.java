public void testQueryByInvolvedGroupOrUserO(){
assertEquals(1,taskService.createTaskQuery().or().taskInvolvedUser("involvedUser").taskInvolvedGroupsIn(groups).endOr().count());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals(1,historyService.createHistoricTaskInstanceQuery().or().taskInvolvedUser("involvedUser").taskInvolvedGroupsIn(groups).endOr().count());
}
if (task.getExecutionId() == null) {
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
}
}
}