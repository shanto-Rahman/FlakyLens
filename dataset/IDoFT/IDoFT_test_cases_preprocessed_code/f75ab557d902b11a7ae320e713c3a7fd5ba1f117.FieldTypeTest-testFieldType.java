@Test public void testFieldType() throws Exception {
assertTrue(fields.length >= 4);
assertEquals(nameField.getName(),fieldType.getFieldName());
assertEquals(nameField.getName(),fieldType.getColumnName());
assertEquals(DataType.STRING.getDataPersister(),fieldType.getDataPersister());
assertEquals(0,fieldType.getWidth());
assertTrue(fieldType.toString().contains("Foo"));
assertTrue(fieldType.toString().contains(nameField.getName()));
assertEquals(RANK_DB_COLUMN_NAME,fieldType.getColumnName());
assertEquals(DataType.STRING.getDataPersister(),fieldType.getDataPersister());
assertEquals(RANK_WIDTH,fieldType.getWidth());
assertEquals(serialField.getName(),fieldType.getColumnName());
assertEquals(DataType.INTEGER_OBJ.getDataPersister(),fieldType.getDataPersister());
assertEquals(Integer.parseInt(SERIAL_DEFAULT_VALUE),fieldType.getDefaultValue());
assertEquals(intLongField.getName(),fieldType.getColumnName());
assertFalse(fieldType.isGeneratedId());
assertEquals(DataType.LONG.getDataPersister(),fieldType.getDataPersister());
}