@Test public void testCombineProperties(){
  Properties truststoreProps=new Properties();
  truststoreProps.setProperty(NiFiProperties.SECURITY_TRUSTSTORE,TRUSTSTORE);
  truststoreProps.setProperty(NiFiProperties.SECURITY_TRUSTSTORE_PASSWD,TRUSTSTORE_PASSWORD);
  truststoreProps.setProperty(NiFiProperties.SECURITY_TRUSTSTORE_TYPE,TRUSTSTORE_TYPE);
  NiFiProperties combinedProperties=ZooKeeperStateProvider.combineProperties(nifiProperties,truststoreProps);
  assertEquals(KEYSTORE,combinedProperties.getProperty(NiFiProperties.SECURITY_KEYSTORE));
  assertEquals(TRUSTSTORE,combinedProperties.getProperty(NiFiProperties.SECURITY_TRUSTSTORE));
}
