@Test(expected=IllegalArgumentException.class) public void getHomeDirNotDef(){
  ServerWebApp.getHomeDir("TestServerWebApp00");
}
