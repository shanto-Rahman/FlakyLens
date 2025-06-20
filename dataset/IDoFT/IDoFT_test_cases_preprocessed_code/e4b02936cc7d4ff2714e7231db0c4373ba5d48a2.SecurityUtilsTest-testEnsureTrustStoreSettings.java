@Test public void testEnsureTrustStoreSettings() throws URISyntaxException {
assertTrue(trustStore == null || "".equals(trustStore));
assertTrue(trustStorePassword == null || "".equals(trustStorePassword));
assertNull(securityProperties);
assertNotNull(trustStore);
assertEquals("/foo/bar/trustStore",trustStore);
assertNotNull(trustStorePassword);
assertEquals("secret",trustStorePassword);
assertNull(securityProperties);
assertNotNull(trustStore);
assertEquals("/foo/bar/trustStore",trustStore);
assertNotNull(trustStorePassword);
assertEquals("secret",trustStorePassword);
assertNotNull(securityProperties);
assertEquals("/foo/bar/ignored",securityProperties);
assertNotNull(trustStore);
assertEquals("/foo/bar/trustStore1",trustStore);
assertNotNull(trustStorePassword);
assertEquals("secret1",trustStorePassword);
assertNotNull(securityProperties);
assertEquals(securityPropertiesValue,securityProperties);
assertNotNull(trustStore);
assertEquals("/foo/bar/trustStore2",trustStore);
assertNotNull(trustStorePassword);
assertEquals("secret2",trustStorePassword);
assertNotNull(securityProperties);
assertEquals(securityPropertiesValue,securityProperties);
}