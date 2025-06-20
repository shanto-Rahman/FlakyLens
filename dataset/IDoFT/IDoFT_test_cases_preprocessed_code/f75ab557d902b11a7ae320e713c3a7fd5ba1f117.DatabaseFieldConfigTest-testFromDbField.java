@Test public void testFromDbField() throws Exception {
assertTrue(fields.length >= 1);
assertNotNull(config);
assertTrue(config.isCanBeNull());
assertEquals(fields[0].getName(),config.getFieldName());
}