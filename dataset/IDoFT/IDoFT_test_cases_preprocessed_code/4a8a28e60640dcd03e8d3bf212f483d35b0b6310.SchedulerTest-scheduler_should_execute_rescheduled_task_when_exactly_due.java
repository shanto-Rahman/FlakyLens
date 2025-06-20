@Test public void scheduler_should_execute_rescheduled_task_when_exactly_due(){
assertThat(handler.timesExecuted,is(0));
assertThat(handler.timesExecuted,is(0));
assertThat(handler.timesExecuted,is(1));
}