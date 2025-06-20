@Test public void should_fail_if_not_same_column_name() throws Exception {
assertThat(comparator.isEqual(sourceColumnMetadata,targetColumnMetadata)).isFalse();
}