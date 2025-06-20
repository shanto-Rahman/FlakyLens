@Test public void testCreateStatements() throws Exception {
  List<String> stmts=TableUtils.getCreateTableStatements(databaseType,LocalFoo.class);
  assertEquals(1,stmts.size());
  assertEquals(expectedCreateStatement(),stmts.get(0));
}
