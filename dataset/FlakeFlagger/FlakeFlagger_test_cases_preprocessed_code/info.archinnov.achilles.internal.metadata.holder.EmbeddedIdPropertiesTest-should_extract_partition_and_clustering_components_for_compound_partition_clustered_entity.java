@Test public void should_extract_partition_and_clustering_components_for_compound_partition_clustered_entity() throws Exception {
assertThat(props.extractPartitionComponents(components)).containsExactly(10L,"type");
assertThat(props.extractClusteringComponents(components)).containsExactly(date,"name");
}