@Test public void testMembershipJoinAndLeave() throws Exception {
  Membership membership=membershipFactory.create(cluster);
  membership.join(endpoint);
  String path=ZKClusterPaths.endpoint(cluster,endpoint);
  CuratorFramework curatorFramework=curatorFrameworkProvider.get();
  byte[] data=curatorFramework.getData().forPath(path);
  Endpoint endpoint0=Endpoint.fromJSON(data);
  Stat stat=curatorFramework.checkExists().forPath(path);
  System.out.printf("stat: %s\n",stat);
  System.out.printf("stat (ephemeral owner): %s\n",stat.getEphemeralOwner());
  assertTrue(stat.getEphemeralOwner() > 0);
  assertNotNull(stat);
  assertEquals(endpoint.toString(),endpoint0.toString());
  membership.leave(endpoint);
  stat=curatorFramework.checkExists().forPath(path);
  assertNull(stat);
}
