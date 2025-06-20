@Test public void assertFindJobExecutionEventsWithFields(){
JobEventRdbSearch.Result<JobExecutionEvent> result=repository.findJobExecutionEvents(new JobEventRdbSearch.Condition(10,1,null,null,null,null,fields));//RW
assertThat(result.getTotal(),is(250));
assertThat(result.getRows().size(),is(10));
result=repository.findJobExecutionEvents(new JobEventRdbSearch.Condition(10,1,null,null,null,null,fields));//RW
assertThat(result.getTotal(),is(1));
assertThat(result.getRows().size(),is(1));
}