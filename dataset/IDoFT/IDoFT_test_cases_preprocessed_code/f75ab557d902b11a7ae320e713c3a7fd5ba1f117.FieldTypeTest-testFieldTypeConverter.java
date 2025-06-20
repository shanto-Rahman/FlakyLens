@Test public void testFieldTypeConverter() throws Exception {
assertTrue(fields.length >= 4);
resultToSqlArgCalled.set(true);
assertEquals(sqlType,fieldType.getSqlType());
assertEquals(nameArg,fieldType.extractJavaFieldToSqlArgValue(foo));
assertEquals(nameResult,fieldType.resultToJava(resultMock,new HashMap<String,Integer>()));
assertTrue(resultToSqlArgCalled.get());
}