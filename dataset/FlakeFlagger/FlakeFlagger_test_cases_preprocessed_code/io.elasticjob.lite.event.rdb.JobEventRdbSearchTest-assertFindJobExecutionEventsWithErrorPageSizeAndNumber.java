@Test public void assertFindJobExecutionEventsWithErrorPageSizeAndNumber(){
JobEventRdbSearch.Result<JobExecutionEvent> result=repository.findJobExecutionEvents(new JobEventRdbSearch.Condition(-1,-1,null,null,null,null,null));//RW
assertThat(result.getTotal(),is(500));
assertThat(result.getRows().size(),is(10));
}