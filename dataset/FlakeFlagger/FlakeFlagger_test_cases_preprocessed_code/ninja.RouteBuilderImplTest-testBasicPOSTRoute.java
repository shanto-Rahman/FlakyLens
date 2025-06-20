@Test public void testBasicPOSTRoute(){
assertTrue(buildRoute(routeBuilder).matches("POST","/index"));
}