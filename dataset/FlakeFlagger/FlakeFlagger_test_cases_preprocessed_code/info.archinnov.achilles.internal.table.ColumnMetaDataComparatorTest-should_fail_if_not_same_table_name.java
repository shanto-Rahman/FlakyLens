@Test public void should_fail_if_not_same_table_name() throws Exception {
assertThat(comparator.isEqual(sourceColumnMetadata,targetColumnMetadata)).isFalse();
}