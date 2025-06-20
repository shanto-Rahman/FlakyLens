@Test public void testDropMultipleColumnsMySQL(){
  DropColumnStatement drop=new DropColumnStatement(Arrays.asList(new DropColumnStatement(null,null,"TEST_TABLE","col1"),new DropColumnStatement(null,null,"TEST_TABLE","col2")));
  Assert.assertFalse(generatorUnderTest.validate(drop,new MySQLDatabase(),new MockSqlGeneratorChain()).hasErrors());
  Sql[] sql=generatorUnderTest.generateSql(drop,new MySQLDatabase(),new MockSqlGeneratorChain());
  Assert.assertEquals(1,sql.length);
  Assert.assertEquals("ALTER TABLE TEST_TABLE DROP col1, DROP col2",sql[0].toSql());
  Assert.assertEquals("[DEFAULT, TEST_TABLE, TEST_TABLE.col1, TEST_TABLE.col2]",String.valueOf(sql[0].getAffectedDatabaseObjects()));
}
