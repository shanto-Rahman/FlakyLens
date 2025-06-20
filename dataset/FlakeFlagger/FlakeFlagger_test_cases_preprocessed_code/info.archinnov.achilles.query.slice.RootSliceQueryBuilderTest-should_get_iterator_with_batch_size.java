@Test public void should_get_iterator_with_batch_size() throws Exception {
assertThat(Whitebox.getInternalState(builder,"batchSize")).isEqualTo(7);
assertThat(actual).isSameAs(iterator);
}