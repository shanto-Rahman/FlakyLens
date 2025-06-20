@Test public void scheduler_should_execute_rescheduled_task_when_exactly_due(){
  OneTimeTask<Void> oneTimeTask=TestTasks.oneTime("OneTime",Void.class,handler);
  Scheduler scheduler=schedulerFor(oneTimeTask);
  Instant executionTime=clock.now().plus(Duration.ofMinutes(1));
  String instanceId="1";
  TaskInstance<Void> oneTimeTaskInstance=oneTimeTask.instance(instanceId);
  scheduler.schedule(oneTimeTaskInstance,executionTime);
  Instant reScheduledExecutionTime=clock.now().plus(Duration.ofMinutes(2));
  scheduler.reschedule(oneTimeTaskInstance,reScheduledExecutionTime);
  scheduler.executeDue();
  assertThat(handler.timesExecuted,is(0));
  clock.set(executionTime);
  scheduler.executeDue();
  assertThat(handler.timesExecuted,is(0));
  clock.set(reScheduledExecutionTime);
  scheduler.executeDue();
  assertThat(handler.timesExecuted,is(1));
}
