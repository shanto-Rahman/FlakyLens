@Test public void should_get_first_with_clustering_components() throws Exception {
assertThat(actual).isSameAs(entity);
assertThat(Whitebox.getInternalState(builder,"limit")).isEqualTo(1);
assertThat(Whitebox.<List<Object>>getInternalState(builder,"fromClusterings")).containsExactly(clusteringComponents);
assertThat(Whitebox.<List<Object>>getInternalState(builder,"toClusterings")).containsExactly(clusteringComponents);
}