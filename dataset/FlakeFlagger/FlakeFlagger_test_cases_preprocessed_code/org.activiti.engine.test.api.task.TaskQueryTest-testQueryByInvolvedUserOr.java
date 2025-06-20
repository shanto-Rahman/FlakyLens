public void testQueryByInvolvedUserOr(){
assertEquals(3,taskService.getIdentityLinksForTask(adhocTask.getId()).size());
assertEquals(1,taskService.createTaskQuery().taskId(adhocTask.getId()).or().taskId("invalid").taskInvolvedUser(GONZO).count());
assertEquals(1,taskService.createTaskQuery().taskId(adhocTask.getId()).or().taskId("invalid").taskInvolvedUser(KERMIT).count());
assertEquals(1,taskService.createTaskQuery().taskId(adhocTask.getId()).or().taskId("invalid").taskInvolvedUser(FOZZIE).count());
if (task.getExecutionId() == null) {
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
}
}
}