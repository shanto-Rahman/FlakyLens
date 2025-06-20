@Test public void testPointsInRegexDontCrashRegexInTheMiddleOfTheRoute(){
assertTrue(route.matches("GET",routeFromServer));
assertEquals(1,route.getPathParametersEncoded(routeFromServer).entrySet().size());
assertEquals("my.id",route.getPathParametersEncoded(routeFromServer).get("id"));
assertFalse(route.matches("GET",routeFromServer));
assertEquals(0,route.getPathParametersEncoded(routeFromServer).entrySet().size());
}