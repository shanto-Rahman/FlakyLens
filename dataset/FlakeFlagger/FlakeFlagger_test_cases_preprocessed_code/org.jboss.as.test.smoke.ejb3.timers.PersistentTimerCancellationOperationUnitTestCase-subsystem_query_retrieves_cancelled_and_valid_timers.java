@Test public void subsystem_query_retrieves_cancelled_and_valid_timers() throws Exception {
assertThat(node.get(ModelDescriptionConstants.OUTCOME).asString(),is("success"));
assertThat(timerIDs.size(),is(2));
assertThat(nonCancelledTimers.size(),is(1));
assertThat(cancelledTimers.size(),is(1));
}