@Test public void should_dsl_select_with_token_value() throws Exception {
  Long id=RandomUtils.nextLong(0L,Long.MAX_VALUE);
  scriptExecutor.executeScriptTemplate("EntityWithCaseSensitivePK/insert1row.cql",ImmutableMap.of("partitionKey",id));
  final EntityWithCaseSensitivePK found=manager.dsl().select().list().set().map().udt().allColumns().fromBaseTable().where().tokenValueOf_partitionKey().Gt(Long.MIN_VALUE).getOne();
  assertThat(found).isNotNull();
  assertThat(found.getList()).containsExactly("1","2");
  assertThat(found.getSet()).containsExactly("1","2");
  assertThat(found.getMap()).containsEntry(1,"1");
  assertThat(found.getMap()).containsEntry(2,"2");
  assertThat(found.getUdt().getId()).isEqualTo(1L);
  assertThat(found.getUdt().getValue()).isEqualTo("test");
}
