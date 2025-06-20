@Test public void testCombineNullNiFiPropsWithPropertiesOverrides(){
assertEquals(OVERRIDE_KEYSTORE,combinedProperties.getProperty(NiFiProperties.SECURITY_KEYSTORE));
assertEquals(OVERRIDE_KEYSTORE_PASSWORD,combinedProperties.getProperty(NiFiProperties.SECURITY_KEYSTORE_PASSWD));
}