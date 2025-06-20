@Test public void should_dsl_select_with_token_value() throws Exception {
  final long id=RandomUtils.nextLong(0L,Long.MAX_VALUE);
  final Date date=buildDateKey();
  scriptExecutor.executeScriptTemplate("SimpleEntity/insert_single_row.cql",ImmutableMap.of("id",id,"table","simple"));
  final SimpleEntity actual=manager.dsl().select().consistencyList().simpleSet().simpleMap().value().fromBaseTable().where().tokenValueOf_id().Gte_And_Lte(Long.MIN_VALUE,Long.MAX_VALUE).getOne();
  assertThat(actual).isNotNull();
  assertThat(actual.getConsistencyList()).containsExactly(ConsistencyLevel.QUORUM,ConsistencyLevel.LOCAL_ONE);
  assertThat(actual.getSimpleSet()).containsExactly(1.0,2.0);
  assertThat(actual.getSimpleMap()).containsEntry(10,"ten");
  assertThat(actual.getSimpleMap()).containsEntry(20,"twenty");
}
