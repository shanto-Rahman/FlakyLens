@Test public void testRouteWithUrlEncodedSlashGetsChoppedCorrectly(){
assertTrue(route.matches("GET",routeFromServer));
assertEquals(1,route.getPathParametersEncoded(routeFromServer).entrySet().size());
assertEquals("my%2fid",route.getPathParametersEncoded(routeFromServer).get("id"));
}