@Test public void testDubboProtocolMultiService() throws Exception {
assertEquals("world",service.echo("world"));
assertEquals("hello world@" + RemoteServiceImpl.class.getName(),remote.sayHello("world"));
assertEquals(serviceEcho.$echo("test"),"test");
assertEquals(remoteEecho.$echo("ok"),"ok");
}