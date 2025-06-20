@Test public void should_extract_partition_and_clustering_components_for_non_cluster_compound_partition_key() throws Exception {
assertThat(props.extractPartitionComponents(components)).containsExactly(10L,"type");
assertThat(props.extractClusteringComponents(components)).isEmpty();
}