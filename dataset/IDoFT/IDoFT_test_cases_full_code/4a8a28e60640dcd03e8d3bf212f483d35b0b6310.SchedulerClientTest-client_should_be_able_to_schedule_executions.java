@Test public void client_should_be_able_to_schedule_executions(){
  SchedulerClient client=SchedulerClient.Builder.create(DB.getDataSource()).build();
  client.schedule(oneTimeTaskA.instance("1"),settableClock.now());
  scheduler.runAnyDueExecutions();
  assertThat(onetimeTaskHandlerA.timesExecuted,CoreMatchers.is(1));
}
