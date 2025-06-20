@Test public void should_be_able_to_schedule_other_executions_from_an_executionhandler(){
assertThat(scheduleAnother.timesExecuted,CoreMatchers.is(1));
assertThat(onetimeTaskHandlerA.timesExecuted,CoreMatchers.is(0));
assertThat(onetimeTaskHandlerA.timesExecuted,CoreMatchers.is(1));
}