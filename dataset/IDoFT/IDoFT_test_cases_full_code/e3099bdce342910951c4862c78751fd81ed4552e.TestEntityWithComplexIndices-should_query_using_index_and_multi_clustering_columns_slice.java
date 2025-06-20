@Test public void should_query_using_index_and_multi_clustering_columns_slice() throws Exception {
  final Long id=RandomUtils.nextLong(0L,Long.MAX_VALUE);
  scriptExecutor.executeScriptTemplate("EntityWithIndicesForJSON/insertRows.cql",ImmutableMap.of("id",id));
  final List<EntityWithComplexIndices> actual=manager.indexed().select().allColumns_FromBaseTable().where().indexed_simpleIndex().Eq("312").clust1_clust2_clust3().clust1_And_clust2_And_clust3_Gte_And_clust1_And_clust2_Lte(1,1,"1",3,2).getList();
  assertThat(actual).hasSize(1);
  final EntityWithComplexIndices entity=actual.get(0);
  assertThat(entity.getSimpleIndex()).isEqualTo("312");
}
