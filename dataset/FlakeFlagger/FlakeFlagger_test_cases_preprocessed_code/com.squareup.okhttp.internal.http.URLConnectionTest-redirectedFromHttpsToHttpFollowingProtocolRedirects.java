@Test public void redirectedFromHttpsToHttpFollowingProtocolRedirects() throws Exception {
assertNull(connection.getCipherSuite());
assertNull(connection.getLocalCertificates());
assertNull(connection.getServerCertificates());
assertNull(connection.getPeerPrincipal());
assertNull(connection.getLocalPrincipal());
}