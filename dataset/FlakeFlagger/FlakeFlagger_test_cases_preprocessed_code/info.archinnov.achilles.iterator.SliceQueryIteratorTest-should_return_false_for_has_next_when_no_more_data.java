@Test public void should_return_false_for_has_next_when_no_more_data() throws Exception {
assertThat(sliceIterator.hasNext()).isFalse();
}