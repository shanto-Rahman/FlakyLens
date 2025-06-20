@Test public void scheduler_should_detect_dead_execution_that_never_updated_heartbeat(){
  final Instant now=Instant.now();
  settableClock.set(now.minus(Duration.ofHours(1)));
  final Instant oneHourAgo=settableClock.now();
  final TaskInstance<Void> taskInstance=nonCompleting.instance("id1");
  final Execution execution1=new Execution(oneHourAgo,taskInstance);
  jdbcTaskRepository.createIfNotExists(execution1);
  scheduler.executeDue();
  assertThat(nonCompletingExecutionHandler.timesExecuted,is(1));
  scheduler.executeDue();
  assertThat(nonCompletingExecutionHandler.timesExecuted,is(1));
  settableClock.set(Instant.now());
  scheduler.detectDeadExecutions();
  assertThat(deadExecutionHandler.timesCalled,is(1));
  settableClock.set(Instant.now());
  scheduler.executeDue();
  assertThat(nonCompletingExecutionHandler.timesExecuted,is(2));
}
