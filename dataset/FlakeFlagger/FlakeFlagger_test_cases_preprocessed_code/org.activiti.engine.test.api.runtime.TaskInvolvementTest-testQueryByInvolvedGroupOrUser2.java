public void testQueryByInvolvedGroupOrUser2(){
assertEquals(2,taskService.createTaskQuery().or().taskInvolvedUser("user1").taskInvolvedGroupsIn(groups).endOr().count());
assertEquals(2,taskService.createTaskQuery().or().taskCandidateUser("user1").taskInvolvedGroupsIn(groups).endOr().count());
assertEquals(2,taskService.createTaskQuery().or().taskCandidateGroup("group2").taskInvolvedGroupsIn(groups).endOr().count());
if (task.getExecutionId() == null) {
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
}
}
}