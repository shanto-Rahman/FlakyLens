@Test public void testFieldForeign() throws Exception {
  Field[] fields=ForeignParent.class.getDeclaredFields();
  assertTrue(fields.length >= 3);
  @SuppressWarnings("unused") Field idField=fields[0];
  Field nameField=fields[1];
  Field bazField=fields[2];
  FieldType fieldType=FieldType.createFieldType(databaseType,ForeignParent.class.getSimpleName(),nameField,ForeignParent.class);
  assertEquals(nameField.getName(),fieldType.getColumnName());
  assertEquals(DataType.STRING.getDataPersister(),fieldType.getDataPersister());
  assertFalse(fieldType.isForeign());
  assertEquals(0,fieldType.getWidth());
  fieldType=FieldType.createFieldType(databaseType,ForeignParent.class.getSimpleName(),bazField,ForeignParent.class);
  fieldType.configDaoInformation(connectionSource,ForeignParent.class);
  assertEquals(bazField.getName() + FieldType.FOREIGN_ID_FIELD_SUFFIX,fieldType.getColumnName());
  assertEquals(DataType.INTEGER.getDataPersister(),fieldType.getDataPersister());
  assertTrue(fieldType.isForeign());
}
