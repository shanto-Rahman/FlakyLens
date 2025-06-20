@Test public void scheduler_should_handle_dead_executions(){
assertThat(due,Matchers.hasSize(1));
assertTrue(rescheduled.isPresent());
assertThat(rescheduled.get().picked,is(false));
assertThat(rescheduled.get().pickedBy,nullValue());
assertThat(jdbcTaskRepository.getDue(Instant.now()),hasSize(1));
}