@Test public void testJavaxUnique() throws Exception {
assertTrue(fields.length >= 1);
assertNotNull(config);
assertTrue(config.isUnique());
assertEquals(fields[0].getName(),config.getFieldName());
}