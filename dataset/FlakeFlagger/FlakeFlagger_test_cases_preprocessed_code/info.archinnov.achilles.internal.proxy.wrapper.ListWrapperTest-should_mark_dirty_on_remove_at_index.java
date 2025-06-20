@Test public void should_mark_dirty_on_remove_at_index() throws Exception {
assertThat(target).hasSize(1);
assertThat(target.get(0)).isEqualTo("a");
}