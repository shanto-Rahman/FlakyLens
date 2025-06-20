@Test public void should_search_using_like_non_tokenizer() throws Exception {
  Long id=RandomUtils.nextLong(0L,Long.MAX_VALUE);
  scriptExecutor.executeScriptTemplate("EntityWithSASIIndices/insertRows.cql",ImmutableMap.of("id",id));
  final List<EntityWithSASIIndices> actual=manager.indexed().select().allColumns_FromBaseTable().where().indexed_prefixNonTokenizer().Like("speedster").indexed_sparse().Gte(13).indexed_sparse().Lte(15).getList();
  assertThat(actual).hasSize(1);
  assertThat(actual.get(0).getPrefixNonTokenizer()).isEqualTo("speedster");
}
