@Test public void test_create2() throws Exception {
  String sql="CREATE RESOURCE GROUP sql_thread TYPE = USER VCPU = 1,3 THREAD_PRIORITY = -20 disable";
  List<SQLStatement> stmtList=SQLUtils.toStatementList(sql,JdbcConstants.MYSQL);
  SQLStatement stmt=stmtList.get(0);
  MySqlSchemaStatVisitor visitor=new MySqlSchemaStatVisitor();
  stmt.accept(visitor);
  String output=SQLUtils.toMySqlString(stmt);
  Set<String> allPossibleRes=generateAllPossibleRes("CREATE RESOURCE GROUP sql_thread "," DISABLE");
  assertTrue(allPossibleRes.contains(output));
}
