@Test public void should_search_using_prefix_non_tokenizer() throws Exception {
  Long id=RandomUtils.nextLong(0L,Long.MAX_VALUE);
  scriptExecutor.executeScriptTemplate("EntityWithSASIIndices/insertRows.cql",ImmutableMap.of("id",id));
  final List<EntityWithSASIIndices> actual=manager.indexed().select().allColumns_FromBaseTable().where().indexed_prefixNonTokenizer().StartWith("speed").indexed_numeric().Gte(10).indexed_numeric().Lte(15).getList();
  assertThat(actual).hasSize(2);
  assertThat(actual.get(0).getPrefixNonTokenizer()).isEqualTo("speed runner");
  assertThat(actual.get(1).getPrefixNonTokenizer()).isEqualTo("speedster");
}
