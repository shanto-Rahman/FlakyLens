@Test public void should_find_with_runtime_consistency_level_overriding_predefined_one() throws Exception {
assertThat(e).hasMessage("EACH_QUORUM ConsistencyLevel is only supported for writes");
assertThat(exceptionCaught).isTrue();
assertThat(found.getName()).isEqualTo("name rtprt");
}