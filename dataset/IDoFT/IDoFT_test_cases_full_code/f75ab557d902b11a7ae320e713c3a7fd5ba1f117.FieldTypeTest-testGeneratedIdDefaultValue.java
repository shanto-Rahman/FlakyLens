@Test(expected=SQLException.class) public void testGeneratedIdDefaultValue() throws Exception {
  Class<GeneratedIdDefault> clazz=GeneratedIdDefault.class;
  Field[] fields=clazz.getDeclaredFields();
  assertTrue(fields.length >= 1);
  Field idField=fields[0];
  FieldType.createFieldType(databaseType,clazz.getSimpleName(),idField,clazz);
}
