@Test public void test_destroyWontCloseAllProtocol() throws Exception {
assertEquals(0,InjvmProtocol.getDefaultPort());
assertEquals("ok",echoProxy.echo("ok"));
assertThat(expected.getMessage(),containsString("of interface org.apache.dubbo.rpc.Protocol is not adaptive method!"));
assertEquals("ok2",echoProxy.echo("ok2"));
}