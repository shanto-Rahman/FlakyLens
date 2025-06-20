@Test public void testFilterWithLocalNonNamedVolumes() throws Throwable {
  ContainerVolumeDescription volumeDesc=createVolumeDescription("Postgres",VMDK_VOLUME_DRIVER);
  CompositeDescription compositeDesc=createCompositeDesc(false,false,volumeDesc);
  String[] volumes=new String[]{volumeDesc.name + ":/tmp"};
  ContainerVolumeState volume=createVolumeState(volumeDesc);
  createCompositeComponent(compositeDesc,volume);
  ContainerDescription desc=createDescription();
  desc.volumes=volumes;
  filter=new ClusterLocalAffinityHostFilter(host,desc);
  assertTrue(filter.isActive());
  Map<String,HostSelection> selected=filter();
  assertEquals(3,selected.size());
}
