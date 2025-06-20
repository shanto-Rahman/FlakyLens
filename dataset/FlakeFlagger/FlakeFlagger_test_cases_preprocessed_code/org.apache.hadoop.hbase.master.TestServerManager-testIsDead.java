@Test public void testIsDead(){
assertFalse(ServerManager.isDead(deadServers,hostname123,false));
assertFalse(ServerManager.isDead(deadServers,hostname123,true));
assertTrue(ServerManager.isDead(deadServers,hostname123,false));
assertFalse(ServerManager.isDead(deadServers,"one:1",true));
assertFalse(ServerManager.isDead(deadServers,"one:1234",true));
assertTrue(ServerManager.isDead(deadServers,"one:123",true));
}