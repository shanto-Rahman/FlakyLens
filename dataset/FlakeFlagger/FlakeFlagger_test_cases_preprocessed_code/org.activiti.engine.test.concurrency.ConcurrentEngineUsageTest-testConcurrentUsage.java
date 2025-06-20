@Deployment public void testConcurrentUsage() throws Exception {
if (!processEngineConfiguration.getDatabaseType().equals("h2") && !processEngineConfiguration.getDatabaseType().equals("db2")) {
executor.execute(new ConcurrentProcessRunnerRunnable(numberOfProcessesPerThread,"kermit" + i));
executor.shutdown();
boolean isEnded=executor.awaitTermination(20000,TimeUnit.MILLISECONDS);
if (!isEnded) {
log.error("Executor was not shut down after timeout, not al tasks have been executed");//RW
executor.shutdownNow();
}
assertEquals(0,executor.getActiveCount());
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(numberOfProcessesPerThread * numberOfThreads,historyService.createHistoricProcessInstanceQuery().finished().count());
assertEquals(totalNumberOfTasks,historyService.createHistoricTaskInstanceQuery().finished().count());
}
}
}