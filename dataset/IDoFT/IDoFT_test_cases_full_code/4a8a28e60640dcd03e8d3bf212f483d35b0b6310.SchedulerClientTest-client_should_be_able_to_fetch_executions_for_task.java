@Test public void client_should_be_able_to_fetch_executions_for_task(){
  SchedulerClient client=SchedulerClient.Builder.create(DB.getDataSource(),oneTimeTaskA,oneTimeTaskB).build();
  client.schedule(oneTimeTaskA.instance("1"),settableClock.now());
  client.schedule(oneTimeTaskA.instance("2"),settableClock.now());
  client.schedule(oneTimeTaskB.instance("10"),settableClock.now());
  client.schedule(oneTimeTaskB.instance("11"),settableClock.now());
  client.schedule(oneTimeTaskB.instance("12"),settableClock.now());
  assertThat(countAllExecutions(client),is(5));
  assertThat(countExecutionsForTask(client,oneTimeTaskA.getName(),Void.class),is(2));
  assertThat(countExecutionsForTask(client,oneTimeTaskB.getName(),Void.class),is(3));
}
