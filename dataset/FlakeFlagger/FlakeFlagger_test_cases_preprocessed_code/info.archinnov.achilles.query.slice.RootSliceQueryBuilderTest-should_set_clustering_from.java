@Test public void should_set_clustering_from() throws Exception {
assertThat(builder.buildClusterQuery().getClusteringsFrom()).containsExactly(10L,11L,"a",12);
}