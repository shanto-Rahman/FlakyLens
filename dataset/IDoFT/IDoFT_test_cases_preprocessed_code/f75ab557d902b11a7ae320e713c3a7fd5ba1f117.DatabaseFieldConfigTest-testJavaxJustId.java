@Test public void testJavaxJustId() throws Exception {
assertTrue(fields.length >= 1);
assertNotNull(config);
assertTrue(config.isId());
assertFalse(config.isGeneratedId());
assertFalse(config.isUseGetSet());
assertEquals(fields[0].getName(),config.getFieldName());
}