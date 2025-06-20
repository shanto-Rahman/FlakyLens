@Test public void testDeletePath(){
assertThat(zkclientZookeeperClient.checkExists(path),is(true));
assertThat(zkclientZookeeperClient.checkExists(path),is(false));
}