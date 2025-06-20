@Test public void should_set_clustering_to() throws Exception {
assertThat(builder.buildClusterQuery().getClusteringsTo()).containsExactly(10L,11L,"a",12);
}