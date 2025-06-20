@Test public void assertPersistEphemeral() throws Exception {
zkRegCenter.persist("/persist","persist_value");//RW
zkRegCenter.persistEphemeral("/ephemeral","ephemeral_value");//RW
assertThat(zkRegCenter.get("/persist"),is("persist_value"));//RW
assertThat(zkRegCenter.get("/ephemeral"),is("ephemeral_value"));//RW
zkRegCenter.close();//RW
assertThat(client.getData().forPath("/" + ZookeeperRegistryCenterModifyTest.class.getName() + "/persist"),is("persist_value".getBytes()));
assertNull(client.checkExists().forPath("/" + ZookeeperRegistryCenterModifyTest.class.getName() + "/ephemeral"));
zkRegCenter.init();//RW
}