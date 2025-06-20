@Test public void should_query_using_map_key_entry_fromJSON() throws Exception {
  final Long id=RandomUtils.nextLong(0L,Long.MAX_VALUE);
  scriptExecutor.executeScriptTemplate("EntityWithIndicesForJSON/insertRows.cql",ImmutableMap.of("id",id));
  final List<EntityWithIndicesForJSON> actual=manager.indexed().select().allColumns_FromBaseTable().where().indexed_indexOnMapEntry().ContainsEntry_FromJSON("212","\"212\"").getList();
  assertThat(actual).hasSize(1);
  final EntityWithIndicesForJSON entity=actual.get(0);
  assertThat(entity.getSimpleIndex()).isEqualTo("212");
}
