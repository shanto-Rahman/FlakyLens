@Test public void should_search_using_contains() throws Exception {
  Long id=RandomUtils.nextLong(0L,Long.MAX_VALUE);
  scriptExecutor.executeScriptTemplate("EntityWithSASIIndices/insertRows.cql",ImmutableMap.of("id",id));
  final List<EntityWithSASIIndices> actual=manager.indexed().select().allColumns_FromBaseTable().where().indexed_containsStandardAnalyzer().Contains("love").getList();
  assertThat(actual).hasSize(5);
  assertThat(actual.get(0).getContainsStandardAnalyzer()).isEqualTo("forever love");
  assertThat(actual.get(1).getContainsStandardAnalyzer()).isEqualTo("lovers");
  assertThat(actual.get(2).getContainsStandardAnalyzer()).isEqualTo("the white gloves");
  assertThat(actual.get(3).getContainsStandardAnalyzer()).isEqualTo("the loving man");
  assertThat(actual.get(4).getContainsStandardAnalyzer()).isEqualTo("no love");
}
