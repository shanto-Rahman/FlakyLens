@Test public void testConversionRuleSupportInPatternLayout() throws JoranException {
assertNotNull(sla);
assertEquals(1,sla.strList.size());
assertEquals(SampleConverter.SAMPLE_STR + " - " + msg,sla.strList.get(0));
}