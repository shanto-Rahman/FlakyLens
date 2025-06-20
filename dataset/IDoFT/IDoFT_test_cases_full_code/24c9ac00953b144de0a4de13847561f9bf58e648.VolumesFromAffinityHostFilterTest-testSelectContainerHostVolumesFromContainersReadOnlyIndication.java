@Test public void testSelectContainerHostVolumesFromContainersReadOnlyIndication() throws Throwable {
  ContainerDescription desc1=createDescriptionsWithVolumesFrom(CONTAINER_NAME,2,null).get(0);
  ContainerState container1=createContainer(desc1);
  String[] volumesFrom=new String[]{CONTAINER_NAME + ":ro"};
  ContainerDescription volumesFromDesc=createDescriptionsWithVolumesFrom("random-name38",1,volumesFrom).get(0);
  filter=new VolumesFromAffinityHostFilter(host,volumesFromDesc);
  Collection<String> expectedFilteredHostLinks=Arrays.asList(container1.parentLink);
  Throwable e=filter(expectedFilteredHostLinks);
  if (e != null) {
    fail("Unexpected exception: " + e);
  }
}
