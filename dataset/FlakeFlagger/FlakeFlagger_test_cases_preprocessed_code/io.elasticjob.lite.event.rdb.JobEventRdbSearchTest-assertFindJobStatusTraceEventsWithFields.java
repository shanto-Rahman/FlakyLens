@Test public void assertFindJobStatusTraceEventsWithFields(){
JobEventRdbSearch.Result<JobStatusTraceEvent> result=repository.findJobStatusTraceEvents(new JobEventRdbSearch.Condition(10,1,null,null,null,null,fields));//RW
assertThat(result.getTotal(),is(1));
assertThat(result.getRows().size(),is(1));
}