@Test public void testBasicRoutesWithRegex(){
assertTrue(route.matches("GET","/index"));
assertTrue(route.matches("GET","/stylesheet.css"));
assertTrue(route.matches("GET","/public/stylesheet.css"));
assertTrue(route.matches("GET","/public/bootstrap.js"));
}