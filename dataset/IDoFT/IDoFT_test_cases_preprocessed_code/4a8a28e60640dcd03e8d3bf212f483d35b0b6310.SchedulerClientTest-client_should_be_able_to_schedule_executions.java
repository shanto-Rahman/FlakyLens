@Test public void client_should_be_able_to_schedule_executions(){
assertThat(onetimeTaskHandlerA.timesExecuted,CoreMatchers.is(1));
}