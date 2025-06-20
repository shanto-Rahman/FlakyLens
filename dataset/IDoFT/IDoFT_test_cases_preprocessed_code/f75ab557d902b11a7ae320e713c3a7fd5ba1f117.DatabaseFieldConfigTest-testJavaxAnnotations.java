@Test public void testJavaxAnnotations() throws Exception {
assertTrue(fields.length >= 7);
assertNull(DatabaseFieldConfig.fromField(databaseType,"foo",fields[0]));
assertNotNull(config);
assertFalse(config.isId());
assertTrue(config.isGeneratedId());
assertFalse(config.isUseGetSet());
assertEquals(fields[1].getName(),config.getFieldName());
assertNotNull(config);
assertFalse(config.isUseGetSet());
assertEquals(STUFF_FIELD_NAME,config.getColumnName());
assertNotNull(config);
assertEquals(LENGTH_LENGTH,config.getWidth());
assertFalse(config.isUseGetSet());
assertEquals(fields[3].getName(),config.getFieldName());
assertNotNull(config);
assertFalse(config.isCanBeNull());
assertFalse(config.isUseGetSet());
assertEquals(fields[4].getName(),config.getFieldName());
assertNotNull(config);
assertTrue(config.isForeign());
assertNull(config.getDataPersister());
assertEquals(fields[5].getName(),config.getFieldName());
assertNotNull(config);
assertTrue(config.isForeign());
assertNull(config.getDataPersister());
assertEquals(fields[6].getName(),config.getFieldName());
}