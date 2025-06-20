@Test public void recyclingNonAliveConnectionClosesThatConnection() throws Exception {
assertTrue(httpA.getSocket().isClosed());
}