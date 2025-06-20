@Test public void should_get_clustering_order() throws Exception {
assertThat(meta.getClusteringOrders()).containsExactly(clusteringOrder);
}