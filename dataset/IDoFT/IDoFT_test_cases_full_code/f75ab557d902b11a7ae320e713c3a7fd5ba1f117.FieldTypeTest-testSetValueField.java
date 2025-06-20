@Test public void testSetValueField() throws Exception {
  Field[] fields=LocalFoo.class.getDeclaredFields();
  assertTrue(fields.length >= 4);
  Field nameField=fields[0];
  FieldType fieldType=FieldType.createFieldType(databaseType,LocalFoo.class.getSimpleName(),nameField,LocalFoo.class);
  LocalFoo foo=new LocalFoo();
  String name1="wfwef";
  fieldType.assignField(connectionSource,foo,name1,false,null);
  assertEquals(name1,foo.name);
}
