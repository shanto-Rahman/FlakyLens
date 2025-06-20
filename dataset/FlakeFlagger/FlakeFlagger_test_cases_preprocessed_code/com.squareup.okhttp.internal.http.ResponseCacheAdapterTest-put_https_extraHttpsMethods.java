@Test public void put_https_extraHttpsMethods() throws Exception {
assertEquals("https",serverUrl.getProtocol());
assertEquals(realHttpsUrlConnection.getCipherSuite(),cacheHttpsUrlConnection.getCipherSuite());
assertEquals(realHttpsUrlConnection.getPeerPrincipal(),cacheHttpsUrlConnection.getPeerPrincipal());
assertArrayEquals(realHttpsUrlConnection.getLocalCertificates(),cacheHttpsUrlConnection.getLocalCertificates());
assertArrayEquals(realHttpsUrlConnection.getServerCertificates(),cacheHttpsUrlConnection.getServerCertificates());
assertEquals(realHttpsUrlConnection.getLocalPrincipal(),cacheHttpsUrlConnection.getLocalPrincipal());
}