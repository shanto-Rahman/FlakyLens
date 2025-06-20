@Test public void testCreateStatementsTableConfig() throws Exception {
  List<String> stmts=TableUtils.getCreateTableStatements(connectionSource,DatabaseTableConfig.fromClass(databaseType,LocalFoo.class));
  assertEquals(1,stmts.size());
  assertEquals(expectedCreateStatement(),stmts.get(0));
}
