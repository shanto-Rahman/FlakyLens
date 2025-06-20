@Test public void should_override_runtime_value_by_batch_setting() throws Exception {
assertThat(actual.getConsistencyLevel().isPresent()).isTrue();
assertThat(actual.getConsistencyLevel().get()).isEqualTo(EACH_QUORUM);
}