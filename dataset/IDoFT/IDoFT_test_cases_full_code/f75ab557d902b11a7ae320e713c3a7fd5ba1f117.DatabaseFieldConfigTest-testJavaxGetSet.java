@Test public void testJavaxGetSet() throws Exception {
  Field[] fields=JavaxGetSet.class.getDeclaredFields();
  assertTrue(fields.length >= 1);
  DatabaseFieldConfig config=DatabaseFieldConfig.fromField(databaseType,"foo",fields[0]);
  assertNotNull(config);
  assertTrue(config.isUseGetSet());
  assertEquals(fields[0].getName(),config.getFieldName());
}
