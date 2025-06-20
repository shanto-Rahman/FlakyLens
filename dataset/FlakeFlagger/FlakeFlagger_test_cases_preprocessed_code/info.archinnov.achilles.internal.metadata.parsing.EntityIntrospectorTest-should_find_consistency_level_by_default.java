@Test public void should_find_consistency_level_by_default() throws Exception {
assertThat(levels.left).isEqualTo(ONE);
assertThat(levels.right).isEqualTo(TWO);
}