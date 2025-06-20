@Test public void should_get_first_n_with_clustering_components() throws Exception {
assertThat(Whitebox.getInternalState(builder,"limit")).isEqualTo(3);
assertThat(Whitebox.<List<Object>>getInternalState(builder,"fromClusterings")).containsExactly(clusteringComponents);
assertThat(Whitebox.<List<Object>>getInternalState(builder,"toClusterings")).containsExactly(clusteringComponents);
}