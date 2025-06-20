@Test public void assertFindJobExecutionEventsWithErrorFields(){
JobEventRdbSearch.Result<JobExecutionEvent> result=repository.findJobExecutionEvents(new JobEventRdbSearch.Condition(10,1,null,null,null,null,fields));//RW
assertThat(result.getTotal(),is(500));
assertThat(result.getRows().size(),is(10));
}