@Test public void testCheckExists(){
assertThat(curatorClient.checkExists(path),is(true));
assertThat(curatorClient.checkExists(path + "/noneexits"),is(false));
}