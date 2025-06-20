@Test public void testPointsInRegexDontCrashRegexAtEnd(){
assertTrue(route.matches("GET","/blah/my.id"));
assertEquals(1,route.getPathParametersEncoded(routeFromServer).entrySet().size());
assertEquals("my.id",route.getPathParametersEncoded(routeFromServer).get("id"));
}