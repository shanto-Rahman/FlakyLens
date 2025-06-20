@Test public void should_get_clustering_component_names_and_classes() throws Exception {
assertThat(props.getClusteringComponentNames()).containsExactly("date","name");
assertThat(props.getClusteringComponentClasses()).containsExactly(UUID.class,String.class);
assertThat(props.isClustered()).isTrue();
}