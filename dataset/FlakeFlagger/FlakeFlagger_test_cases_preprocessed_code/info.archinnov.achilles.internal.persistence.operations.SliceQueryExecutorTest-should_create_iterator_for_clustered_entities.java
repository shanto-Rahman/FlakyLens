@Test public void should_create_iterator_for_clustered_entities() throws Exception {
assertThat(iter).isNotNull();
assertThat(iter).isInstanceOf(SliceQueryIterator.class);
}