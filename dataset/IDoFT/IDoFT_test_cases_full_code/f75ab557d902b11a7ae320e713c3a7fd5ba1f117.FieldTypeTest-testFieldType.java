@Test public void testFieldType() throws Exception {
  Field[] fields=LocalFoo.class.getDeclaredFields();
  assertTrue(fields.length >= 4);
  Field nameField=fields[0];
  Field rankField=fields[1];
  Field serialField=fields[2];
  Field intLongField=fields[3];
  FieldType fieldType=FieldType.createFieldType(databaseType,LocalFoo.class.getSimpleName(),nameField,LocalFoo.class);
  assertEquals(nameField.getName(),fieldType.getFieldName());
  assertEquals(nameField.getName(),fieldType.getColumnName());
  assertEquals(DataType.STRING.getDataPersister(),fieldType.getDataPersister());
  assertEquals(0,fieldType.getWidth());
  assertTrue(fieldType.toString().contains("Foo"));
  assertTrue(fieldType.toString().contains(nameField.getName()));
  fieldType=FieldType.createFieldType(databaseType,LocalFoo.class.getSimpleName(),rankField,LocalFoo.class);
  assertEquals(RANK_DB_COLUMN_NAME,fieldType.getColumnName());
  assertEquals(DataType.STRING.getDataPersister(),fieldType.getDataPersister());
  assertEquals(RANK_WIDTH,fieldType.getWidth());
  fieldType=FieldType.createFieldType(databaseType,LocalFoo.class.getSimpleName(),serialField,LocalFoo.class);
  assertEquals(serialField.getName(),fieldType.getColumnName());
  assertEquals(DataType.INTEGER_OBJ.getDataPersister(),fieldType.getDataPersister());
  assertEquals(Integer.parseInt(SERIAL_DEFAULT_VALUE),fieldType.getDefaultValue());
  String tableName=LocalFoo.class.getSimpleName();
  fieldType=FieldType.createFieldType(databaseType,tableName,intLongField,LocalFoo.class);
  assertEquals(intLongField.getName(),fieldType.getColumnName());
  assertFalse(fieldType.isGeneratedId());
  assertEquals(DataType.LONG.getDataPersister(),fieldType.getDataPersister());
}
