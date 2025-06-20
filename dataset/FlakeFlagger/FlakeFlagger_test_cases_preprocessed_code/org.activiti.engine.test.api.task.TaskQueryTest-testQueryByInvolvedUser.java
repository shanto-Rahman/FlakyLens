public void testQueryByInvolvedUser(){
assertEquals(3,taskService.getIdentityLinksForTask(adhocTask.getId()).size());
assertEquals(1,taskService.createTaskQuery().taskId(adhocTask.getId()).taskInvolvedUser(GONZO).count());
assertEquals(1,taskService.createTaskQuery().taskId(adhocTask.getId()).taskInvolvedUser(KERMIT).count());
assertEquals(1,taskService.createTaskQuery().taskId(adhocTask.getId()).taskInvolvedUser(FOZZIE).count());
if (task.getExecutionId() == null) {
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
}
}
}