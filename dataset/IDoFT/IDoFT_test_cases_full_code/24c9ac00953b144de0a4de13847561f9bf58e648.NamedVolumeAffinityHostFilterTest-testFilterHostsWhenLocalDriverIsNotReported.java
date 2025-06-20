@Test public void testFilterHostsWhenLocalDriverIsNotReported() throws Throwable {
  String hostLink=createDockerHostWithVolumeDrivers("vsphere");
  ContainerVolumeDescription volumeDescription=createVolumeDescription("myvol","local");
  CompositeDescription compositeDesc=createCompositeDesc(false,false,volumeDescription);
  ContainerVolumeState volume=createVolumeState(volumeDescription);
  createCompositeComponent(compositeDesc,volume);
  assertEquals(4,initialHostLinks.size());
  ContainerDescription containerDesc=createContainerDescription(new String[]{"myvol:/tmp"});
  filter=new NamedVolumeAffinityHostFilter(host,containerDesc);
  Map<String,HostSelection> selectedHosts=filter();
  assertEquals(4,selectedHosts.size());
  assertTrue(selectedHosts.keySet().contains(hostLink));
}
