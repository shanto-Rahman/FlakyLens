@Test public void customAuthenticator() throws Exception {
assertEquals(1,authenticator.calls.size());
assertTrue(call,call.contains("proxy=DIRECT"));
assertTrue(call,call.contains("url=" + server.getUrl("/private")));
assertTrue(call,call.contains("challenges=[Basic realm=\"protected area\"]"));
}