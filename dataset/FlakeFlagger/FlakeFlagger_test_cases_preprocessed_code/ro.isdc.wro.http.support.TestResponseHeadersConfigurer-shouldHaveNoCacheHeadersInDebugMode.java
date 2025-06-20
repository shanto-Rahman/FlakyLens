@Test public void shouldHaveNoCacheHeadersInDebugMode(){
assertEquals(3,map.size());
assertEquals("no-cache",map.get(HttpHeader.PRAGMA.getHeaderName()));
assertEquals("no-cache",map.get(HttpHeader.CACHE_CONTROL.getHeaderName()));
assertEquals("0",map.get(HttpHeader.EXPIRES.getHeaderName()));
}