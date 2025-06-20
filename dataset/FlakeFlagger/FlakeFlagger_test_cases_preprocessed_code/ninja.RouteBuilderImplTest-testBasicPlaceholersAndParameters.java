@Test public void testBasicPlaceholersAndParameters(){
assertFalse(route.matches("GET","/dashboard"));
assertTrue(route.matches("GET","/John/dashboard"));
assertEquals(1,map.entrySet().size());
assertEquals("John",map.get("name"));
assertFalse(route.matches("GET","/dashboard"));
assertTrue(route.matches("GET","/John/20/dashboard"));
assertEquals(2,map.entrySet().size());
assertEquals("John",map.get("name"));
assertEquals("20",map.get("id"));
}