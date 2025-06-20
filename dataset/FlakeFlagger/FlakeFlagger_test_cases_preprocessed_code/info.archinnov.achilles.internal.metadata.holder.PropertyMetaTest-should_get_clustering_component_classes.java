@Test public void should_get_clustering_component_classes() throws Exception {
assertThat(pm.getClusteringComponentClasses()).containsExactly(UUID.class,String.class);
}