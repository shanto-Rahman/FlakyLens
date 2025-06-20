@Test public void secureResponseCaching() throws IOException {
assertEquals("ABC",readAscii(c1));
assertEquals("ABC",readAscii(c2));
assertEquals(suite,c2.getCipherSuite());
assertEquals(localCerts,toListOrNull(c2.getLocalCertificates()));
assertEquals(serverCerts,toListOrNull(c2.getServerCertificates()));
assertEquals(peerPrincipal,c2.getPeerPrincipal());
assertEquals(localPrincipal,c2.getLocalPrincipal());
}