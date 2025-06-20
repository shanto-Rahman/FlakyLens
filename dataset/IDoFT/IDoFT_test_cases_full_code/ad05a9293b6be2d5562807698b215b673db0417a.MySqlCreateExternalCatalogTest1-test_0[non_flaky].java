public void test_0() throws Exception {
  String sql="CREATE EXTERNAL CATALOG IF NOT EXISTS kafka_1 PROPERTIES (" + "'connector.name'='kafka' " + "'kafka.table-names'='table1,table2' "+ "'kafka.nodes'='1.1.1.1:10000,1.1.1.2:10000') COMMENT 'this is a kafka connector test.'";
  MySqlStatementParser parser=new MySqlStatementParser(sql);
  List<SQLStatement> stmtList=parser.parseStatementList();
  assertEquals(1,stmtList.size());
  SQLStatement stmt=stmtList.get(0);
  Set<String> allPossibleRes=generateAllPossibleRes4test0();
  assertTrue(allPossibleRes.contains(stmt.toString()));
}
