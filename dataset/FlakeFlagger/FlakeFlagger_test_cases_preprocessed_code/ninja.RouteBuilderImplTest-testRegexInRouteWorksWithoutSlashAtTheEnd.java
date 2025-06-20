@Test public void testRegexInRouteWorksWithoutSlashAtTheEnd(){
assertTrue(route.matches("GET",routeFromServer));
assertEquals(1,route.getPathParametersEncoded(routeFromServer).entrySet().size());
assertEquals("my.id",route.getPathParametersEncoded(routeFromServer).get("id"));
assertTrue(route.matches("GET","/blah/my.id/"));
assertEquals(1,route.getPathParametersEncoded(routeFromServer).entrySet().size());
assertEquals("my.id",route.getPathParametersEncoded(routeFromServer).get("id"));
assertFalse(route.matches("GET","/blah/my.id"));
}