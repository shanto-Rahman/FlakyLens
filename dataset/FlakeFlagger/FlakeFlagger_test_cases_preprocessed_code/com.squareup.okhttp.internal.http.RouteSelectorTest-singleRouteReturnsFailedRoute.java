@Test public void singleRouteReturnsFailedRoute() throws Exception {
assertTrue(routeSelector.hasNext());
assertFalse(routeSelector.hasNext());
fail();
}