@Test public void testVolumeProvisioningTaskWithProvidedHostIds() throws Throwable {
  ContainerVolumeDescription volumeDesc=TestRequestStateFactory.createContainerVolumeDescription("My-Vol");
  volumeDesc.documentSelfLink=UUID.randomUUID().toString();
  volumeDesc=doPost(volumeDesc,ContainerVolumeDescriptionService.FACTORY_LINK);
  ComputeDescription dockerHostDesc=createDockerHostDescription();
  if (dockerHostDesc.customProperties == null) {
    dockerHostDesc.customProperties=new HashMap<>();
  }
  ComputeState dockerHost1=createDockerHost(dockerHostDesc,resourcePool,true);
  addForDeletion(dockerHost1);
  ComputeState dockerHost2=createDockerHost(dockerHostDesc,resourcePool,true);
  addForDeletion(dockerHost2);
  RequestBrokerState request=TestRequestStateFactory.createRequestState(ResourceType.VOLUME_TYPE.getName(),volumeDesc.documentSelfLink);
  String hostIds=dockerHost1.id + "," + dockerHost2.id;
  request.customProperties=new HashMap<>();
  request.customProperties.put(ReservationAllocationTaskService.CONTAINER_HOST_ID_CUSTOM_PROPERTY,hostIds);
  host.log("########  Start of request ######## ");
  request=startRequest(request);
  request=waitForRequestToComplete(request);
  Set<String> volumeLinks=request.resourceLinks;
  Iterator<String> volumeLinkIterator=volumeLinks.iterator();
  ContainerVolumeState vol1=getDocument(ContainerVolumeState.class,volumeLinkIterator.next());
  ContainerVolumeState vol2=getDocument(ContainerVolumeState.class,volumeLinkIterator.next());
  assertNotNull(vol1);
  assertNotNull(vol2);
  List<String> hostLinks=Arrays.asList(dockerHost1.documentSelfLink,dockerHost2.documentSelfLink);
  assertTrue(hostLinks.contains(vol1.originatingHostLink));
  assertTrue(hostLinks.contains(vol2.originatingHostLink));
  assertFalse(vol1.originatingHostLink.equals(vol2.originatingHostLink));
}
