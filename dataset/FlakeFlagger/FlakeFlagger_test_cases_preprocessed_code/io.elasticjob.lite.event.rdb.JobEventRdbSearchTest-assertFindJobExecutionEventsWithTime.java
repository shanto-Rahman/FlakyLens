@Test public void assertFindJobExecutionEventsWithTime(){
JobEventRdbSearch.Result<JobExecutionEvent> result=repository.findJobExecutionEvents(new JobEventRdbSearch.Condition(10,1,null,null,tenMinutesBefore,null,null));//RW
assertThat(result.getTotal(),is(500));
assertThat(result.getRows().size(),is(10));
result=repository.findJobExecutionEvents(new JobEventRdbSearch.Condition(10,1,null,null,now,null,null));//RW
assertThat(result.getTotal(),is(0));
assertThat(result.getRows().size(),is(0));
result=repository.findJobExecutionEvents(new JobEventRdbSearch.Condition(10,1,null,null,null,tenMinutesBefore,null));//RW
assertThat(result.getTotal(),is(0));
assertThat(result.getRows().size(),is(0));
result=repository.findJobExecutionEvents(new JobEventRdbSearch.Condition(10,1,null,null,null,now,null));//RW
assertThat(result.getTotal(),is(500));
assertThat(result.getRows().size(),is(10));
result=repository.findJobExecutionEvents(new JobEventRdbSearch.Condition(10,1,null,null,tenMinutesBefore,now,null));//RW
assertThat(result.getTotal(),is(500));
assertThat(result.getRows().size(),is(10));
}