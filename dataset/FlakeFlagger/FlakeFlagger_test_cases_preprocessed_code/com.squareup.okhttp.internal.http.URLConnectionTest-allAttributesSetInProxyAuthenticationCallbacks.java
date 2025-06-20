@Test public void allAttributesSetInProxyAuthenticationCallbacks() throws Exception {
assertEquals(1,calls.size());
assertTrue(call,call.contains("host=" + url.getHost()));
assertTrue(call,call.contains("port=" + url.getPort()));
assertTrue(call,call.contains("site=" + InetAddress.getAllByName(url.getHost())[0]));
assertTrue(call,call.contains("url=http://android.com"));
assertTrue(call,call.contains("type=" + Authenticator.RequestorType.PROXY));
assertTrue(call,call.contains("prompt=Bar"));
assertTrue(call,call.contains("protocol=http"));
assertTrue(call,call.toLowerCase().contains("scheme=basic"));
}