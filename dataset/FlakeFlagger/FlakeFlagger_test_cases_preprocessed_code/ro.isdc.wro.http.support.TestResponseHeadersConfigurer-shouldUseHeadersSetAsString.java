@Test public void shouldUseHeadersSetAsString(){
assertEquals("v1",map.get("h1"));
assertEquals("v2",map.get("h2"));
assertEquals(2,map.size());
}