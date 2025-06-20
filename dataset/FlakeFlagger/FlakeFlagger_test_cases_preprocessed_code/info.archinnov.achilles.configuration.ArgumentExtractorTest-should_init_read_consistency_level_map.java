@Test public void should_init_read_consistency_level_map() throws Exception {
assertThat(consistencyMap.get("cf1")).isEqualTo(ConsistencyLevel.ONE);
assertThat(consistencyMap.get("cf2")).isEqualTo(ConsistencyLevel.LOCAL_QUORUM);
}