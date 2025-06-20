public void testQueryByInvolvedGroupAndUser(){
assertEquals(3,taskService.getIdentityLinksForTask(adhocTask.getId()).size());
assertEquals(0,taskService.createTaskQuery().taskInvolvedUser("involvedUser").taskInvolvedGroupsIn(groups).count());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals(0,historyService.createHistoricTaskInstanceQuery().taskInvolvedUser("involvedUser").taskInvolvedGroupsIn(groups).count());
}
if (task.getExecutionId() == null) {
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
}
}
}