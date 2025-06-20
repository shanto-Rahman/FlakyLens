@Test public void testCheckExists(){
assertThat(zkclientZookeeperClient.checkExists(path),is(true));
assertThat(zkclientZookeeperClient.checkExists(path + "/noneexits"),is(false));
}