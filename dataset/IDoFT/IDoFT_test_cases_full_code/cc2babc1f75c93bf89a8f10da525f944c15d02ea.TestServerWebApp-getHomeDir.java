@Test public void getHomeDir(){
  System.setProperty("TestServerWebApp0.home.dir","/tmp");
  assertEquals(ServerWebApp.getHomeDir("TestServerWebApp0"),"/tmp");
  assertEquals(ServerWebApp.getDir("TestServerWebApp0",".log.dir","/tmp/log"),"/tmp/log");
  System.setProperty("TestServerWebApp0.log.dir","/tmplog");
  assertEquals(ServerWebApp.getDir("TestServerWebApp0",".log.dir","/tmp/log"),"/tmplog");
}
