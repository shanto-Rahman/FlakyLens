@Test public void should_compare_list_type() throws Exception {
assertThat(comparator.isEqual(sourceColumnMetadata,targetColumnMetadata)).isTrue();
}