@Test public void testCanBeNull() throws Exception {
  Field[] fields=CanBeNull.class.getDeclaredFields();
  assertTrue(fields.length >= 2);
  Field field=fields[0];
  FieldType fieldType=FieldType.createFieldType(databaseType,CanBeNull.class.getSimpleName(),field,CanBeNull.class);
  assertTrue(fieldType.isCanBeNull());
  field=fields[1];
  fieldType=FieldType.createFieldType(databaseType,CanBeNull.class.getSimpleName(),field,CanBeNull.class);
  assertFalse(fieldType.isCanBeNull());
}
