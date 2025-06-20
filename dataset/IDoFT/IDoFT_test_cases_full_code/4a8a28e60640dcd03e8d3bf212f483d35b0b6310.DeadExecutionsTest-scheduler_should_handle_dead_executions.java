@Test public void scheduler_should_handle_dead_executions(){
  final Instant now=settableClock.now();
  final TaskInstance<Void> taskInstance=oneTimeTask.instance("id1");
  final Execution execution1=new Execution(now.minus(Duration.ofDays(1)),taskInstance);
  jdbcTaskRepository.createIfNotExists(execution1);
  final List<Execution> due=jdbcTaskRepository.getDue(now);
  assertThat(due,Matchers.hasSize(1));
  final Execution execution=due.get(0);
  final Optional<Execution> pickedExecution=jdbcTaskRepository.pick(execution,now);
  jdbcTaskRepository.updateHeartbeat(pickedExecution.get(),now.minus(Duration.ofHours(1)));
  scheduler.detectDeadExecutions();
  final Optional<Execution> rescheduled=jdbcTaskRepository.getExecution(taskInstance);
  assertTrue(rescheduled.isPresent());
  assertThat(rescheduled.get().picked,is(false));
  assertThat(rescheduled.get().pickedBy,nullValue());
  assertThat(jdbcTaskRepository.getDue(Instant.now()),hasSize(1));
}
