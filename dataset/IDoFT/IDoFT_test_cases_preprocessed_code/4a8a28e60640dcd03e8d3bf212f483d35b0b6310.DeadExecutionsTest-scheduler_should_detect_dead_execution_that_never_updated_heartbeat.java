@Test public void scheduler_should_detect_dead_execution_that_never_updated_heartbeat(){
assertThat(nonCompletingExecutionHandler.timesExecuted,is(1));
assertThat(nonCompletingExecutionHandler.timesExecuted,is(1));
assertThat(deadExecutionHandler.timesCalled,is(1));
assertThat(nonCompletingExecutionHandler.timesExecuted,is(2));
}