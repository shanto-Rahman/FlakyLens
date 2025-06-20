@Test public void should_find_consistency_level_from_map_overriding_default() throws Exception {
assertThat(levels.left).isEqualTo(THREE);
assertThat(levels.right).isEqualTo(ALL);
}