@Test public void testBasicPlaceholersParametersAndRegex(){
assertTrue(route.matches("GET","/John/20/dashboard"));
assertEquals(1,map.entrySet().size());
assertEquals("20",map.get("id"));
assertTrue(route.matches("GET","/John/20/admin"));
assertEquals(1,map.entrySet().size());
assertEquals("20",map.get("id"));
assertTrue(route.matches("GET","/John/20/mock"));
assertEquals(1,map.entrySet().size());
assertEquals("20",map.get("id"));
}