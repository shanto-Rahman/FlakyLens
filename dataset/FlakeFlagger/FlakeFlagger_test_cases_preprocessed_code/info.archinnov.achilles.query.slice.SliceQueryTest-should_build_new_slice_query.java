@Test public void should_build_new_slice_query() throws Exception {
assertThat(sliceQuery.getEntityClass()).isSameAs(ClusteredEntity.class);
assertThat(sliceQuery.getBatchSize()).isEqualTo(99);
assertThat(sliceQuery.getBounding()).isEqualTo(BoundingMode.INCLUSIVE_BOUNDS);
assertThat(sliceQuery.getClusteringsFrom()).containsExactly(11L,"a");
assertThat(sliceQuery.getClusteringsTo()).containsExactly(11L,"b");
assertThat(sliceQuery.getConsistencyLevel()).isNull();
assertThat(sliceQuery.getLimit()).isEqualTo(100);
assertThat(sliceQuery.getMeta()).isSameAs(meta);
assertThat(sliceQuery.getOrdering()).isSameAs(OrderingMode.DESCENDING);
assertThat(sliceQuery.getPartitionComponents()).containsExactly(11L);
assertThat(sliceQuery.isLimitSet()).isFalse();
}