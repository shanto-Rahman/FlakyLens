@Test public void should_get_last_n_with_clustering_components() throws Exception {
assertThat(Whitebox.getInternalState(builder,"ordering")).isEqualTo(DESCENDING);
assertThat(Whitebox.getInternalState(builder,"limit")).isEqualTo(6);
assertThat(Whitebox.<List<Object>>getInternalState(builder,"fromClusterings")).containsExactly(clusteringComponents);
assertThat(Whitebox.<List<Object>>getInternalState(builder,"toClusterings")).containsExactly(clusteringComponents);
}