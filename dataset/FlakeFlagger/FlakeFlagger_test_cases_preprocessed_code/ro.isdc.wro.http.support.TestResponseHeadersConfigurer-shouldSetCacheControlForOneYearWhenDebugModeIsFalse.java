@Test public void shouldSetCacheControlForOneYearWhenDebugModeIsFalse(){
assertEquals(3,map.size());
assertEquals("public, max-age=315360000",map.get(HttpHeader.CACHE_CONTROL.getHeaderName()));
}