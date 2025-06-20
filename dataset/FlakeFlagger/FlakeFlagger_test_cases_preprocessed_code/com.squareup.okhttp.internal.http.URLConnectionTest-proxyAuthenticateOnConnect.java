@Test public void proxyAuthenticateOnConnect() throws Exception {
assertEquals("CONNECT android.com:443 HTTP/1.1",connect1.getRequestLine());
assertEquals("CONNECT android.com:443 HTTP/1.1",connect2.getRequestLine());
assertEquals("GET /foo HTTP/1.1",get.getRequestLine());
}