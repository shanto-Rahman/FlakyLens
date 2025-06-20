/** 
 * Don't explode if the cache returns a null body. http://b/3373699 
 */
@Test public void responseCacheReturnsNullOutputStream() throws Exception {
aborted.set(true);
assertEquals("abc",readAscii(connection,3));
assertFalse(aborted.get());
}