/** 
 * Tests a situation when a client sends CONNECT to a proxy, but does not receive any reply.
 */
@Ignore @Test public void testConnectStuck() throws IOException {
fail();
assertTrue(e.getMessage().contains("Handshake response not received"));
}