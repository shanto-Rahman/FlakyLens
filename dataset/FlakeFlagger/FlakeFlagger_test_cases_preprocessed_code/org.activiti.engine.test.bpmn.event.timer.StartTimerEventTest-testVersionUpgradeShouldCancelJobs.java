@Deployment public void testVersionUpgradeShouldCancelJobs() throws Exception {
assertEquals(1,jobQuery.count());
assertEquals(1,jobQuery.count());
if (processInstance != null) {
if (!execution.getProcessInstanceId().equals(execution.getId())) {
}
if (activityExecution != null) {
}
}
assertEquals(1,jobQuery.count());
}