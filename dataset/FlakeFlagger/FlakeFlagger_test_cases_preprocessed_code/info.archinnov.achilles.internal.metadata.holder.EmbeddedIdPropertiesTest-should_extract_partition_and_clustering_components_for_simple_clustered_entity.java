@Test public void should_extract_partition_and_clustering_components_for_simple_clustered_entity() throws Exception {
assertThat(props.extractPartitionComponents(components)).containsExactly(10L);
assertThat(props.extractClusteringComponents(components)).containsExactly(date,"name");
}