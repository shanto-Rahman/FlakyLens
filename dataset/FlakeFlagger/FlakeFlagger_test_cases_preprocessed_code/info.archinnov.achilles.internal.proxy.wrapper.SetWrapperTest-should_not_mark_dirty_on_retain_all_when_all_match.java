@Test public void should_not_mark_dirty_on_retain_all_when_all_match() throws Exception {
assertThat(target).containsOnly("a","b","c");
assertThat(dirtyMap).isEmpty();
}