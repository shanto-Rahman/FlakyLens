@Test public void testDefaultDomainConfiguredOnMBeanExport(){
assertNotNull(mBeanExporter);
assertEquals("my-test-domain",ReflectionTestUtils.getField(naming,"defaultDomain"));
}