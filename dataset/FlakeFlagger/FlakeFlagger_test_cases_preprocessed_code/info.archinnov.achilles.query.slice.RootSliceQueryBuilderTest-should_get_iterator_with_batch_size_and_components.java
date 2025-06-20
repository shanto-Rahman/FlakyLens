@Test public void should_get_iterator_with_batch_size_and_components() throws Exception {
assertThat(Whitebox.getInternalState(builder,"batchSize")).isEqualTo(7);
assertThat(actual).isSameAs(iterator);
assertThat(Whitebox.<List<Object>>getInternalState(builder,"fromClusterings")).containsExactly(clusteringComponents);
assertThat(Whitebox.<List<Object>>getInternalState(builder,"toClusterings")).containsExactly(clusteringComponents);
}