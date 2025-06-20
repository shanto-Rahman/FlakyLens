@Test public void testFieldForeign() throws Exception {
assertTrue(fields.length >= 3);
assertEquals(nameField.getName(),fieldType.getColumnName());
assertEquals(DataType.STRING.getDataPersister(),fieldType.getDataPersister());
assertFalse(fieldType.isForeign());
assertEquals(0,fieldType.getWidth());
assertEquals(bazField.getName() + FieldType.FOREIGN_ID_FIELD_SUFFIX,fieldType.getColumnName());
assertEquals(DataType.INTEGER.getDataPersister(),fieldType.getDataPersister());
assertTrue(fieldType.isForeign());
}