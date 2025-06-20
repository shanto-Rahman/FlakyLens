@Test public void should_query_using_simple_index() throws Exception {
  final Long id=RandomUtils.nextLong(0L,Long.MAX_VALUE);
  scriptExecutor.executeScriptTemplate("EntityWithIndicesForJSON/insertRows.cql",ImmutableMap.of("id",id));
  final List<EntityWithComplexIndices> actual=manager.indexed().select().allColumns_FromBaseTable().where().indexed_simpleIndex().Eq("313").getList();
  assertThat(actual).hasSize(1);
  final EntityWithComplexIndices entity=actual.get(0);
  assertThat(entity.getFullIndexOnCollection()).containsExactly("313");
}
