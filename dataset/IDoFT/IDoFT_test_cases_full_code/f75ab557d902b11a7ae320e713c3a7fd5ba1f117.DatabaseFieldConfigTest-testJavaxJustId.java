@Test public void testJavaxJustId() throws Exception {
  Field[] fields=JavaxAnnoJustId.class.getDeclaredFields();
  assertTrue(fields.length >= 1);
  DatabaseFieldConfig config=DatabaseFieldConfig.fromField(databaseType,"foo",fields[0]);
  assertNotNull(config);
  assertTrue(config.isId());
  assertFalse(config.isGeneratedId());
  assertFalse(config.isUseGetSet());
  assertEquals(fields[0].getName(),config.getFieldName());
}
