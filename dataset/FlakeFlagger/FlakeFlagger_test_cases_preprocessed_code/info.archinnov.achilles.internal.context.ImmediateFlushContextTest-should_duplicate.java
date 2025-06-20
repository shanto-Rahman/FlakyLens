@Test public void should_duplicate() throws Exception {
assertThat(actual.consistencyLevel).isEqualTo(LOCAL_QUORUM);
assertThat(actual.serialConsistencyLevel.get()).isEqualTo(ConsistencyLevel.LOCAL_SERIAL);
}