@Test public void ensureNoObjectsAreCreatedClientTest() throws ExecutionException, InterruptedException {
assertEquals("bla",player.sayHello("meh").get());
assertTrue(serverAddresses.contains(client.getHosting().locateActor(player).join()));
}