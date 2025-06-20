@Test public void shouldUseConfiguredDefaultHeaders(){
assertEquals(1,map.size());
assertEquals(etag,map.get(HttpHeader.ETAG.getHeaderName()));
}