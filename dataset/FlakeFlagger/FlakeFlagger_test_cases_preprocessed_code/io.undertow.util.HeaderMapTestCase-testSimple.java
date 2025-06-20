@Test public void testSimple(){
assertEquals(1,headerMap.size());
assertEquals(-1L,headerMap.fiNext(headerMap.fastIterate()));
assertEquals(Headers.HOST,headerMap.fiCurrent(headerMap.fastIterate()).getHeaderName());
assertEquals("yay.undertow.io",headerMap.getFirst(Headers.HOST));
assertEquals("yay.undertow.io",headerMap.getLast(Headers.HOST));
assertEquals("yay.undertow.io",headerMap.get(Headers.HOST,0));
}