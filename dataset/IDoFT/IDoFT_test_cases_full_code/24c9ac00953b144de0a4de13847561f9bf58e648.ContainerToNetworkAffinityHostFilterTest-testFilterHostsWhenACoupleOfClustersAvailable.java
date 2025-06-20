@Test public void testFilterHostsWhenACoupleOfClustersAvailable() throws Throwable {
  ContainerDescription desc=createContainerWithNetworksDescription();
  filter=new ContainerToNetworkAffinityHostFilter(host,desc);
  assertTrue(filter.isActive());
  expectedLinks=new ArrayList<>();
  expectedLinks.add(createDockerHostWithKVStore("kvstore1"));
  expectedLinks.add(createDockerHostWithKVStore("kvstore1"));
  expectedLinks.add(createDockerHostWithKVStore("kvstore1"));
  expectedLinks.add(createDockerHostWithKVStore("kvstore2"));
  expectedLinks.add(createDockerHostWithKVStore("kvstore2"));
  expectedLinks.add(createDockerHostWithKVStore("kvstore2"));
  expectedLinks.add(createDockerHostWithKVStore("kvstore3"));
  expectedLinks.add(createDockerHostWithKVStore("kvstore3"));
  expectedLinks.add(createDockerHostWithKVStore("kvstore3"));
  expectedLinks.add(createDockerHostWithKVStore("kvstore4"));
  expectedLinks.add(createDockerHostWithKVStore("kvstore4"));
  expectedLinks.add(createDockerHostWithKVStore("kvstore4"));
  initialHostLinks.addAll(expectedLinks);
  String kvStoreName=null;
  for (int i=0; i < 3; i++) {
    Map<String,HostSelection> selected=filter();
    for (    String key : selected.keySet()) {
      if (kvStoreName == null) {
        kvStoreName=selected.get(key).clusterStore;
      }
      assertTrue("Selected hosts are not in the same cluster",kvStoreName.equals(selected.get(key).clusterStore));
    }
  }
}
