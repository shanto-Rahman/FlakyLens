@Test public void testAvailable(){
assertThat(zookeeperRegistry.isAvailable(),is(true));
assertThat(zookeeperRegistry.isAvailable(),is(false));
}