@Test public void testAddMultipleColumnsMySql(){
  AddColumnStatement columns=new AddColumnStatement(new AddColumnStatement(null,null,TABLE_NAME,"column1","INT",null,new NotNullConstraint()),new AddColumnStatement(null,null,TABLE_NAME,"column2","INT",null,new NotNullConstraint()));
  assertFalse(generatorUnderTest.validate(columns,new MySQLDatabase(),new MockSqlGeneratorChain()).hasErrors());
  Sql[] sql=generatorUnderTest.generateSql(columns,new MySQLDatabase(),new MockSqlGeneratorChain());
  assertEquals(1,sql.length);
  assertEquals("ALTER TABLE " + TABLE_NAME + " ADD column1 INT NOT NULL, ADD column2 INT NOT NULL",sql[0].toSql());
  assertEquals("[DEFAULT, table_name, table_name.column1, table_name.column2]",String.valueOf(sql[0].getAffectedDatabaseObjects()));
}
