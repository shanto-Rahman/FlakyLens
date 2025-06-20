@Test public void should_be_able_to_schedule_other_executions_from_an_executionhandler(){
  scheduler.schedule(scheduleAnotherTask.instance("1"),settableClock.now());
  scheduler.runAnyDueExecutions();
  assertThat(scheduleAnother.timesExecuted,CoreMatchers.is(1));
  assertThat(onetimeTaskHandlerA.timesExecuted,CoreMatchers.is(0));
  scheduler.tick(ofSeconds(1));
  scheduler.runAnyDueExecutions();
  assertThat(onetimeTaskHandlerA.timesExecuted,CoreMatchers.is(1));
}
