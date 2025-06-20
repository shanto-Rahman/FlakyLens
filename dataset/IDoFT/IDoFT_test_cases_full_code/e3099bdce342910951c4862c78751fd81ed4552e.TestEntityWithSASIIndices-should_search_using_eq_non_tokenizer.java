@Test public void should_search_using_eq_non_tokenizer() throws Exception {
  Long id=RandomUtils.nextLong(0L,Long.MAX_VALUE);
  scriptExecutor.executeScriptTemplate("EntityWithSASIIndices/insertRows.cql",ImmutableMap.of("id",id));
  final List<EntityWithSASIIndices> actual=manager.indexed().select().allColumns_FromBaseTable().where().indexed_prefixNonTokenizer().Eq("speedster").getList();
  assertThat(actual).hasSize(1);
  assertThat(actual.get(0).getPrefixNonTokenizer()).isEqualTo("speedster");
}
