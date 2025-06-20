@Test public void should_find_consistency_level_from_class() throws Exception {
assertThat(levels.left).isEqualTo(ANY);
assertThat(levels.right).isEqualTo(LOCAL_QUORUM);
}