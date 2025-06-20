@Test public void testProvisionContainerWhenAnotherAlreadyProvisionedAndHasVolumesFromRules() throws Throwable {
  ContainerDescription desc=createDescriptionsWithVolumesFrom(CONTAINER_NAME,5,null).get(0);
  ContainerState container=createContainer(desc);
  assertEquals(UriUtils.buildUriPath(CompositeComponentFactoryService.SELF_LINK,state.contextId),container.compositeComponentLink);
  String[] volumesFrom=new String[]{CONTAINER_NAME};
  ContainerDescription volumesFromDesc=createDescriptionsWithVolumesFrom("random-name36",1,volumesFrom).get(0);
  createContainer(volumesFromDesc,container.parentLink);
  filter=new VolumesFromAffinityHostFilter(host,desc);
  Collection<String> expectedFilteredHostLinks=Arrays.asList(container.parentLink);
  state.addCustomProperty(RequestUtils.CLUSTERING_OPERATION_CUSTOM_PROP,"true");
  Throwable e=filter(expectedFilteredHostLinks);
  if (e != null) {
    fail("Unexpected exception: " + e);
  }
}
