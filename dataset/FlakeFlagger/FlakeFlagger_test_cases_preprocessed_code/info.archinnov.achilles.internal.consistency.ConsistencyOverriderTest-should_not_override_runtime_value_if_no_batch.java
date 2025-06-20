@Test public void should_not_override_runtime_value_if_no_batch() throws Exception {
assertThat(actual.getConsistencyLevel().isPresent()).isTrue();
assertThat(actual.getConsistencyLevel().get()).isEqualTo(LOCAL_QUORUM);
}