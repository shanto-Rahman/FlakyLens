@Test public void test_alter() throws Exception {
  String sql="ALTER RESOURCE GROUP sql_thread TYPE = USER VCPU = 1,3 THREAD_PRIORITY = -20";
  List<SQLStatement> stmtList=SQLUtils.toStatementList(sql,JdbcConstants.MYSQL);
  SQLStatement stmt=stmtList.get(0);
  MySqlSchemaStatVisitor visitor=new MySqlSchemaStatVisitor();
  stmt.accept(visitor);
  String output=SQLUtils.toMySqlString(stmt);
  Set<String> allPossibleRes=generateAllPossibleRes("ALTER RESOURCE GROUP sql_thread ","");
  assertTrue(allPossibleRes.contains(output));
}
