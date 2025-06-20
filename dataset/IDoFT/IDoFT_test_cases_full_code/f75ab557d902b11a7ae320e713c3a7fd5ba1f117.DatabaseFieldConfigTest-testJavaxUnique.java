@Test public void testJavaxUnique() throws Exception {
  Field[] fields=JavaxUnique.class.getDeclaredFields();
  assertTrue(fields.length >= 1);
  DatabaseFieldConfig config=DatabaseFieldConfig.fromField(databaseType,"foo",fields[0]);
  assertNotNull(config);
  assertTrue(config.isUnique());
  assertEquals(fields[0].getName(),config.getFieldName());
}
