@Test(expected=SQLException.class) public void testThrowIfNullNotPrimitive() throws Exception {
  Class<ThrowIfNullNonPrimitive> clazz=ThrowIfNullNonPrimitive.class;
  Field[] fields=clazz.getDeclaredFields();
  assertTrue(fields.length >= 1);
  Field field=fields[0];
  FieldType.createFieldType(databaseType,clazz.getSimpleName(),field,clazz);
}
