@Test public void testConversionRuleSupportInHtmlLayout() throws JoranException {
assertNotNull(sla);
assertEquals(1,sla.strList.size());
assertFalse(sla.strList.get(0).contains("PARSER_ERROR"));
}