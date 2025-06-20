@Test public void peerHttp2ClientDisablesPush() throws Exception {
assertFalse(connection.peerSettings.getEnablePush(true));
}