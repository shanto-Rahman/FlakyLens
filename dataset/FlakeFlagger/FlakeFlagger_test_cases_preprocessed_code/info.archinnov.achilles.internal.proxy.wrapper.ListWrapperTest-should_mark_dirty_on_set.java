@Test public void should_mark_dirty_on_set() throws Exception {
assertThat(target).hasSize(3);
assertThat(target.get(1)).isEqualTo("d");
}