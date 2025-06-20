@Test public void should_compare_set_type() throws Exception {
assertThat(comparator.isEqual(sourceColumnMetadata,targetColumnMetadata)).isTrue();
}