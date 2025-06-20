public void testQueryByInvolvedGroup(){
assertEquals(3,taskService.getIdentityLinksForTask(adhocTask.getId()).size());
assertEquals(1,taskService.createTaskQuery().taskId(adhocTask.getId()).taskInvolvedGroupsIn(groups).count());
if (task.getExecutionId() == null) {
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
}
}
}