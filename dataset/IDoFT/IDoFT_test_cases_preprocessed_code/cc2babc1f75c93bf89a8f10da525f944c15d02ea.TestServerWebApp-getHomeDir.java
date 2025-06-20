@Test public void getHomeDir(){
assertEquals(ServerWebApp.getHomeDir("TestServerWebApp0"),"/tmp");
assertEquals(ServerWebApp.getDir("TestServerWebApp0",".log.dir","/tmp/log"),"/tmp/log");
assertEquals(ServerWebApp.getDir("TestServerWebApp0",".log.dir","/tmp/log"),"/tmplog");
}