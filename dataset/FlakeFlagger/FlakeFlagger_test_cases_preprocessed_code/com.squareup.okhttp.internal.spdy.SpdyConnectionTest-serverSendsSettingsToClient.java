@Test public void serverSendsSettingsToClient() throws Exception {
assertEquals(10,connection.peerSettings.getMaxConcurrentStreams(-1));
}