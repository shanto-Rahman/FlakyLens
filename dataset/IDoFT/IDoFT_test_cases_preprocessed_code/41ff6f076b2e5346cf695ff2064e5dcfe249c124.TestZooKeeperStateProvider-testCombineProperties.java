@Test public void testCombineProperties(){
NiFiProperties combinedProperties=ZooKeeperStateProvider.combineProperties(nifiProperties,truststoreProps);//RW
assertEquals(KEYSTORE,combinedProperties.getProperty(NiFiProperties.SECURITY_KEYSTORE));
assertEquals(TRUSTSTORE,combinedProperties.getProperty(NiFiProperties.SECURITY_TRUSTSTORE));
}