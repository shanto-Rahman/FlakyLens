/** 
 * test HttpString.compareTo part: bytes.length - other.bytes.length
 */
@Test public void testCompareShorterFirst(){
Assert.assertEquals(accept.compareTo(Headers.ACCEPT_CHARSET),Headers.ACCEPT.compareTo(Headers.ACCEPT_CHARSET));
Assert.assertEquals(acceptCharset.compareTo(Headers.ACCEPT),Headers.ACCEPT_CHARSET.compareTo(Headers.ACCEPT));
}