@Test public void singleRoute() throws Exception {
assertTrue(routeSelector.hasNext());
dns.assertRequests(uriHost);//IT
assertFalse(routeSelector.hasNext());
fail();
}