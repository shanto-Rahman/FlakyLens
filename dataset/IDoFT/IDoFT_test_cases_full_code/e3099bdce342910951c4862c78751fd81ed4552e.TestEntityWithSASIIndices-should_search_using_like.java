@Test public void should_search_using_like() throws Exception {
  Long id=RandomUtils.nextLong(0L,Long.MAX_VALUE);
  scriptExecutor.executeScriptTemplate("EntityWithSASIIndices/insertRows.cql",ImmutableMap.of("id",id));
  final List<EntityWithSASIIndices> actual=manager.indexed().select().allColumns_FromBaseTable().where().indexed_containsStandardAnalyzer().Like("chair dance").getList();
  assertThat(actual).hasSize(1);
  assertThat(actual.get(0).getContainsStandardAnalyzer()).isEqualTo("the chair is dancing");
}
