/** 
 * Tolerate bad https proxy response when using HttpResponseCache. http://b/6754912 
 */
@Test public void connectViaHttpProxyToHttpsUsingBadProxyAndHttpResponseCache() throws Exception {
fail();
assertEquals("Connect line failure on proxy","CONNECT android.com:443 HTTP/1.1",connect.getRequestLine());
}