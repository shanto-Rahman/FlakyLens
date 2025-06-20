@Test public void should_iterate_by_slice_query() throws Exception {
assertThat(iterator.hasNext()).isTrue();
assertThat(iterator.next().getId().getName()).isEqualTo(name5);
assertThat(iterator.next().getId().getName()).isEqualTo(name4);
assertThat(iterator.next().getId().getName()).isEqualTo(name3);
assertThat(iterator.hasNext()).isFalse();
}