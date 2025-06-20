@Test public void testAddMultipleColumnsMySql(){
assertFalse(generatorUnderTest.validate(columns,new MySQLDatabase(),new MockSqlGeneratorChain()).hasErrors());
assertEquals(1,sql.length);
assertEquals("ALTER TABLE " + TABLE_NAME + " ADD column1 INT NOT NULL, ADD column2 INT NOT NULL",sql[0].toSql());
assertTrue(actualNames.containsAll(expectedNames));
assertTrue(expectedNames.containsAll(actualNames));
}