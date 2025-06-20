public void testQueryMultipleAndAndSingleOr(){
assertEquals(2,taskService.createTaskQuery().taskInvolvedUser("user1").taskInvolvedGroupsIn(andGroup).or().taskInvolvedGroupsIn(orGroup).endOr().count());
if (task.getExecutionId() == null) {
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
}
}
}