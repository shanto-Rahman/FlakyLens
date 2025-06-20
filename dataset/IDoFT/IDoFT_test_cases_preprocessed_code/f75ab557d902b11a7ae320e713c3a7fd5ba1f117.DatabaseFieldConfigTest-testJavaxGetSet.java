@Test public void testJavaxGetSet() throws Exception {
assertTrue(fields.length >= 1);
assertNotNull(config);
assertTrue(config.isUseGetSet());
assertEquals(fields[0].getName(),config.getFieldName());
}