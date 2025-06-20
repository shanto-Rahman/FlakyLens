@Test public void should_get_read_consistency() throws Exception {
assertThat(pm.getReadConsistencyLevel()).isNull();
assertThat(pm.getWriteConsistencyLevel()).isNull();
assertThat(pm.getReadConsistencyLevel()).isEqualTo(QUORUM);
assertThat(pm.getWriteConsistencyLevel()).isEqualTo(QUORUM);
}