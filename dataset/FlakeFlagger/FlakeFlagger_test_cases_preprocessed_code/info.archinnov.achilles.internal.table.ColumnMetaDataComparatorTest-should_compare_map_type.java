@Test public void should_compare_map_type() throws Exception {
assertThat(comparator.isEqual(sourceColumnMetadata,targetColumnMetadata)).isTrue();
}