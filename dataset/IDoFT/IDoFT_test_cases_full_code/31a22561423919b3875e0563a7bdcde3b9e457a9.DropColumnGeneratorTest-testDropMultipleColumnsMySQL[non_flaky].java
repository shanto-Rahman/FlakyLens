@Test public void testDropMultipleColumnsMySQL(){
  DropColumnStatement drop=new DropColumnStatement(Arrays.asList(new DropColumnStatement(null,null,"TEST_TABLE","col1"),new DropColumnStatement(null,null,"TEST_TABLE","col2")));
  Assert.assertFalse(generatorUnderTest.validate(drop,new MySQLDatabase(),new MockSqlGeneratorChain()).hasErrors());
  Sql[] sql=generatorUnderTest.generateSql(drop,new MySQLDatabase(),new MockSqlGeneratorChain());
  Assert.assertEquals(1,sql.length);
  Assert.assertEquals("ALTER TABLE TEST_TABLE DROP col1, DROP col2",sql[0].toSql());
  List<String> actualNames=sql[0].getAffectedDatabaseObjects().stream().map(o -> o.toString()).collect(Collectors.toList());
  List<String> expectedNames=Arrays.asList(new String[]{"TEST_TABLE.col1","TEST_TABLE.col2","TEST_TABLE","DEFAULT"});
  assertTrue(actualNames.containsAll(expectedNames));
  assertTrue(expectedNames.containsAll(actualNames));
}
