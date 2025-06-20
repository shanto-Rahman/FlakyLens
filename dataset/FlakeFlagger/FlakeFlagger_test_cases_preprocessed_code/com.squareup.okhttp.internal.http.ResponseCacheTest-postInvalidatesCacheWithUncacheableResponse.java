/** 
 * Equivalent to  {@link HttpResponseCacheTest#postInvalidatesCacheWithUncacheableResponse()} butdemonstrating that  {@link ResponseCache} provides no mechanism for cache invalidation as theresult of locally-made requests. In reality invalidation could take place from other clients at any time.
 */
@Test public void postInvalidatesCacheWithUncacheableResponse() throws Exception {
assertEquals("A",readAscii(openConnection(url)));
assertEquals("B",readAscii(invalidate));
assertEquals("A",readAscii(openConnection(url)));
}