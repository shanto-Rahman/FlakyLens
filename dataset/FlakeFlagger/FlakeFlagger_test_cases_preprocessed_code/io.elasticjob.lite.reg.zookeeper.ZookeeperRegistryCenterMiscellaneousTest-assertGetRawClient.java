@Test public void assertGetRawClient(){
assertThat(zkRegCenter.getRawClient(),instanceOf(CuratorFramework.class));//RW
assertThat(((CuratorFramework)zkRegCenter.getRawClient()).getNamespace(),is(ZookeeperRegistryCenterMiscellaneousTest.class.getName()));//RW
}