@Test public void testCombineNullNiFiPropsWithPropertiesOverrides(){
  final String OVERRIDE_KEYSTORE="/override/keystore.jks";
  final String OVERRIDE_KEYSTORE_PASSWORD="overridePassword";
  Properties overrideProps=new Properties();
  overrideProps.setProperty(NiFiProperties.SECURITY_KEYSTORE,OVERRIDE_KEYSTORE);
  overrideProps.setProperty(NiFiProperties.SECURITY_KEYSTORE_PASSWD,OVERRIDE_KEYSTORE_PASSWORD);
  NiFiProperties combinedProperties=ZooKeeperStateProvider.combineProperties(null,overrideProps);
  assertEquals(OVERRIDE_KEYSTORE,combinedProperties.getProperty(NiFiProperties.SECURITY_KEYSTORE));
  assertEquals(OVERRIDE_KEYSTORE_PASSWORD,combinedProperties.getProperty(NiFiProperties.SECURITY_KEYSTORE_PASSWD));
}
