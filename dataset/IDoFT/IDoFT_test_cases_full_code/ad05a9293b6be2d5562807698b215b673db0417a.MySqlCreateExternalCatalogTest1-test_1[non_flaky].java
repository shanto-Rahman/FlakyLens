public void test_1() throws Exception {
  String sql="CREATE EXTERNAL CATALOG user_db.mysql_1 PROPERTIES (" + "'connector.name'='mysql' " + "'connection-url'='jdbc:mysql://1.1.1.1:3306' "+ "'connection-user'=\"x'!xx\" "+ "'connection-password'=\"x'xx\")";
  MySqlStatementParser parser=new MySqlStatementParser(sql);
  List<SQLStatement> stmtList=parser.parseStatementList();
  assertEquals(1,stmtList.size());
  SQLStatement stmt=stmtList.get(0);
  Set<String> allPossibleRes=generateAllPossibleRes4test1();
  assertTrue(allPossibleRes.contains(stmt.toString()));
}
