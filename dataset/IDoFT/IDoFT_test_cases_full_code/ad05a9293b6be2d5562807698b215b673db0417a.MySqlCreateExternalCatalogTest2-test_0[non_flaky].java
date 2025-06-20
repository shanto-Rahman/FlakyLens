public void test_0() throws Exception {
  String sql="CREATE EXTERNAL CATALOG shanghao_test.oss_catalog_0\n" + "PROPERTIES\n" + "(\n"+ "  connector.name='oss'\n"+ "  'connection-url'='http://oss-cn-hangzhou-zmf.aliyuncs.com'\n"+ "  'bucket-name'='oss_test'\n"+ "  'connection-user' = 'access_id'\n"+ "  'connection-password' = 'access_key'\n"+ " )\n"+ "COMMENT 'This is a sample to create an oss connector catalog';";
  MySqlStatementParser parser=new MySqlStatementParser(sql);
  List<SQLStatement> stmtList=parser.parseStatementList();
  assertEquals(1,stmtList.size());
  SQLStatement stmt=stmtList.get(0);
  Set<String> allPossibleRes=generateAllPossibleRes();
  assertTrue(allPossibleRes.contains(stmt.toString()));
}
