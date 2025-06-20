@Test public void should_get_clustering_component_names() throws Exception {
assertThat(pm.getClusteringComponentNames()).containsExactly("comp1","comp2");
}