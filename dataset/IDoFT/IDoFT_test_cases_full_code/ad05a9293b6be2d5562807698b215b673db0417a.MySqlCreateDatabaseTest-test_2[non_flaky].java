@Test public void test_2() throws Exception {
  String sql="create database test_cascade for 'ALIYUN$test@aliyun.com' options(resourceType=ecu ecu_type=c1 ecu_count=2)";
  MySqlStatementParser parser=new MySqlStatementParser(sql);
  SQLStatement stmt=parser.parseStatement();
  String output=SQLUtils.toMySqlString(stmt);
  Set<String> allPossibleRes=generateAllPossibleRes();
  assertTrue(allPossibleRes.contains(output));
}
