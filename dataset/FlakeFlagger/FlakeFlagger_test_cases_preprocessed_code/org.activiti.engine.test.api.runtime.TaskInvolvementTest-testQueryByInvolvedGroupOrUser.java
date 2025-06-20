public void testQueryByInvolvedGroupOrUser(){
assertEquals(3,taskService.getIdentityLinksForTask(adhocTask.getId()).size());
assertEquals(1,taskService.createTaskQuery().or().taskInvolvedUser("involvedUser").taskInvolvedGroupsIn(groups).endOr().count());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals(1,historyService.createHistoricTaskInstanceQuery().or().taskCategory("j").taskPriority(10).endOr().or().taskInvolvedUser("involvedUser").taskInvolvedGroupsIn(groups).endOr().count());
}
if (task.getExecutionId() == null) {
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
}
}
}