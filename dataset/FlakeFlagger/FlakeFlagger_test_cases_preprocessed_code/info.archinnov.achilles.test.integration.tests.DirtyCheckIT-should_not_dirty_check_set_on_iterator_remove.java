@Test public void should_not_dirty_check_set_on_iterator_remove() throws Exception {
assertThat(friends).containsOnly("Paul","George");
}