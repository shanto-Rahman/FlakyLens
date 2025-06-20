@Test public void should_init_write_consistency_level_map() throws Exception {
assertThat(consistencyMap.get("cf1")).isEqualTo(THREE);
assertThat(consistencyMap.get("cf2")).isEqualTo(EACH_QUORUM);
}