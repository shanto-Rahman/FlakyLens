@Test public void should_insert_with_insert_strategy_non_null_fields() throws Exception {
  final long id=RandomUtils.nextLong(0L,Long.MAX_VALUE);
  final Date date=buildDateKey();
  scriptExecutor.executeScriptTemplate("SimpleEntity/insert_single_row.cql",ImmutableMap.of("id",id,"table","simple"));
  final SimpleEntity entity=new SimpleEntity(id,date,null);
  manager.crud().insert(entity).withInsertStrategy(InsertStrategy.NOT_NULL_FIELDS).execute();
  final Row row=session.execute("SELECT value FROM simple WHERE id = " + id).one();
  assertThat(row).isNotNull();
  assertThat(row.getString("value")).isEqualTo("0 AM");
}
