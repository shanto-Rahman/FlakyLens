@Test public void nonSslErrorAddsAllTlsModesToFailedRoute() throws Exception {
assertTrue(routeDatabase.failedRoutesCount() == 2);
assertFalse(routeSelector.hasNext());
}