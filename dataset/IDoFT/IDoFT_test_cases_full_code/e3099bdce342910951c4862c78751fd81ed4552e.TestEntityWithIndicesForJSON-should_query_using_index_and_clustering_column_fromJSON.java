@Test public void should_query_using_index_and_clustering_column_fromJSON() throws Exception {
  final Long id=RandomUtils.nextLong(0L,Long.MAX_VALUE);
  scriptExecutor.executeScriptTemplate("EntityWithIndicesForJSON/insertRows.cql",ImmutableMap.of("id",id));
  final List<EntityWithIndicesForJSON> actual=manager.indexed().select().allColumns_FromBaseTable().where().indexed_simpleIndex().Eq("312").clust1().Eq_FromJson("3").clust3().Eq_FromJson("\"2\"").getList();
  assertThat(actual).hasSize(1);
  final EntityWithIndicesForJSON entity=actual.get(0);
  assertThat(entity.getSimpleIndex()).isEqualTo("312");
}
