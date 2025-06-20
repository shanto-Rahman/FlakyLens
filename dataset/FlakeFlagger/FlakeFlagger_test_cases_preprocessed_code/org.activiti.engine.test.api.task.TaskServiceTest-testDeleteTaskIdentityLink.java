public void testDeleteTaskIdentityLink(){
assertNotNull(taskService.createTaskQuery().taskCandidateGroup("sales").singleResult());
assertNotNull(taskService.createTaskQuery().taskCandidateUser("kermit").singleResult());
assertNull(taskService.createTaskQuery().taskCandidateGroup("sales").singleResult());
assertNotNull(taskService.createTaskQuery().taskCandidateUser("kermit").singleResult());
if (task != null && task.getId() != null) {
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
}
}
}