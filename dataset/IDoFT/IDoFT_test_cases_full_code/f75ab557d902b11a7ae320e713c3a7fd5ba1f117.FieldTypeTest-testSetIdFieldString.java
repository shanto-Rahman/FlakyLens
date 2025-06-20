@Test(expected=SQLException.class) public void testSetIdFieldString() throws Exception {
  Field[] fields=LocalFoo.class.getDeclaredFields();
  assertTrue(fields.length >= 4);
  Field nameField=fields[0];
  FieldType fieldType=FieldType.createFieldType(databaseType,LocalFoo.class.getSimpleName(),nameField,LocalFoo.class);
  fieldType.assignIdValue(connectionSource,new LocalFoo(),10,null);
}
