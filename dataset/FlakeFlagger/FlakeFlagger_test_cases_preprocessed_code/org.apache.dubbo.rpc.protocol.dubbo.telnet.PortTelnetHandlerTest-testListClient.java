/** 
 * In NAT network scenario, server's channel.getRemoteAddress() possibly get the address of network gateway, or the address converted by NAT. In this case, check port only.
 */
@Test public void testListClient() throws Exception {
Thread.sleep(5000);
String result=port.telnet(null,"-l 20887");//RW
assertTrue(result.contains(String.valueOf(client1.getLocalAddress().getPort())));
assertTrue(result.contains(String.valueOf(client2.getLocalAddress().getPort())));
}