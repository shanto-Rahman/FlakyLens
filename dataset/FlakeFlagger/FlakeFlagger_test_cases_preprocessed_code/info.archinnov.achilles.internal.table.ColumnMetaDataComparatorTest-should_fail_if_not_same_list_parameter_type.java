@Test public void should_fail_if_not_same_list_parameter_type() throws Exception {
assertThat(comparator.isEqual(sourceColumnMetadata,targetColumnMetadata)).isFalse();
}