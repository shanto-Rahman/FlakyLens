@Test public void testSkippingThroughModesWorks(){
assertEquals("test_testproperty",ninjaPropertiesImpl.get("testproperty"));
assertEquals("dev_testproperty",ninjaPropertiesImpl.get("testproperty"));
assertEquals("secret",ninjaPropertiesImpl.get(NinjaConstant.applicationSecret));
assertEquals("testproperty_without_prefix",ninjaPropertiesImpl.get("testproperty"));
assertEquals("secret",ninjaPropertiesImpl.get(NinjaConstant.applicationSecret));
}