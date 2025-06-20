@Test public void testBasicRoutes(){
assertTrue(buildRoute(routeBuilder).matches("OPTIONS","/index"));
}