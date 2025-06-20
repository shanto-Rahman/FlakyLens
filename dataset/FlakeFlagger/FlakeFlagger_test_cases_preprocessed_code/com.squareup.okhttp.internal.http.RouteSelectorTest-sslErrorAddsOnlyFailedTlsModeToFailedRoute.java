@Test public void sslErrorAddsOnlyFailedTlsModeToFailedRoute() throws Exception {
assertTrue(routeDatabase.failedRoutesCount() == 1);
assertTrue(routeSelector.hasNext());
}