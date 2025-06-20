@Test public void testBasicGETRoute(){
assertTrue(buildRoute(routeBuilder).matches("GET","/index"));
}