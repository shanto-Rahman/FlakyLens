@Test public void testDropMultipleColumnsMySQL(){
Assert.assertFalse(generatorUnderTest.validate(drop,new MySQLDatabase(),new MockSqlGeneratorChain()).hasErrors());
Assert.assertEquals(1,sql.length);
Assert.assertEquals("ALTER TABLE TEST_TABLE DROP col1, DROP col2",sql[0].toSql());
assertTrue(actualNames.containsAll(expectedNames));
assertTrue(expectedNames.containsAll(actualNames));
}