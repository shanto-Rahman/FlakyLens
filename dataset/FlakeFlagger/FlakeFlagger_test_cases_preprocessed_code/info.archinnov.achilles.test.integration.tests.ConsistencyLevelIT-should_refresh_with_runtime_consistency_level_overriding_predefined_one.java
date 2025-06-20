@Test public void should_refresh_with_runtime_consistency_level_overriding_predefined_one() throws Exception {
assertThat(e).hasMessage("EACH_QUORUM ConsistencyLevel is only supported for writes");
assertThat(exceptionCaught).isTrue();
}