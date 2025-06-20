/** 
 * test HttpString.compareTo part: res = signum(higher(bytes[i]) - higher(other.bytes[i]));
 */
@Test public void testCompare(){
Assert.assertEquals(contentType.compareTo(Headers.COOKIE),Headers.CONTENT_TYPE.compareTo(Headers.COOKIE));
Assert.assertEquals(cookie.compareTo(Headers.CONTENT_TYPE),Headers.COOKIE.compareTo(Headers.CONTENT_TYPE));
}