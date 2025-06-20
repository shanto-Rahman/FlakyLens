@Test public void client_should_be_able_to_fetch_executions_for_task(){
assertThat(countAllExecutions(client),is(5));
assertThat(countExecutionsForTask(client,oneTimeTaskA.getName(),Void.class),is(2));
assertThat(countExecutionsForTask(client,oneTimeTaskB.getName(),Void.class),is(3));
}