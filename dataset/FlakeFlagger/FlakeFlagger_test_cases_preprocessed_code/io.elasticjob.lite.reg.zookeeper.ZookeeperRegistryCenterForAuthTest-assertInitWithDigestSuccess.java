@Test public void assertInitWithDigestSuccess() throws Exception {
assertThat(client.getData().forPath("/" + ZookeeperRegistryCenterForAuthTest.class.getName() + "/test/deep/nested"),is("deepNested".getBytes()));
}