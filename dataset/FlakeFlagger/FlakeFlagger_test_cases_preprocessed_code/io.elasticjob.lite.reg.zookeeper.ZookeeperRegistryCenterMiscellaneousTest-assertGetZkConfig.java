@Test public void assertGetZkConfig(){
ZookeeperRegistryCenter zkRegCenter=new ZookeeperRegistryCenter(ZOOKEEPER_CONFIGURATION);//RW
assertThat(zkRegCenter.getZkConfig(),is(ZOOKEEPER_CONFIGURATION));//RW
}