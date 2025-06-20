@Test public void testVolumeProvisioningTaskWithSoftAntiaffinity() throws Throwable {
  String volumeName="Posgres";
  ContainerVolumeDescription volumeDesc=TestRequestStateFactory.createContainerVolumeDescription(volumeName);
  volumeDesc.documentSelfLink=UUID.randomUUID().toString();
  ContainerDescription container1Desc=TestRequestStateFactory.createContainerDescription();
  container1Desc.name="container1";
  container1Desc.volumes=new String[]{volumeName + ":/etc/pgdata/postgres"};
  ContainerDescription container2Desc=TestRequestStateFactory.createContainerDescription();
  container2Desc.name="container2";
  container2Desc.affinity=new String[]{"!container1:soft"};
  container2Desc.volumes=new String[]{volumeName + ":/etc/pgdata/postgres"};
  ResourcePoolState resourcePool=createResourcePool();
  ComputeDescription dockerHostDesc=createDockerHostDescription();
  ComputeState dockerHost1=createDockerHost(dockerHostDesc,resourcePool,true);
  addForDeletion(dockerHost1);
  ComputeState dockerHost2=createDockerHost(dockerHostDesc,resourcePool,true);
  addForDeletion(dockerHost2);
  CompositeDescription compositeDesc=createCompositeDesc(volumeDesc,container1Desc,container2Desc);
  assertNotNull(compositeDesc);
  assertEquals(3,compositeDesc.descriptionLinks.size());
  GroupResourcePlacementState groupPlacementState=createGroupResourcePlacement(resourcePool);
  RequestBrokerState request=TestRequestStateFactory.createRequestState(ResourceType.COMPOSITE_COMPONENT_TYPE.getName(),compositeDesc.documentSelfLink);
  request.tenantLinks=groupPlacementState.tenantLinks;
  host.log("########  Start of request ######## ");
  request=startRequest(request);
  request=waitForRequestToComplete(request);
  CompositeComponent cc=getDocument(CompositeComponent.class,request.resourceLinks.iterator().next());
  assertNotNull(cc.componentLinks);
  assertEquals(cc.componentLinks.size(),3);
  String volumeLink=null;
  String containerLink1=null;
  String containerLink2=null;
  Iterator<String> iterator=cc.componentLinks.iterator();
  while (iterator.hasNext()) {
    String link=iterator.next();
    if (link.startsWith(ContainerVolumeService.FACTORY_LINK)) {
      volumeLink=link;
    }
 else     if (containerLink1 == null) {
      containerLink1=link;
    }
 else {
      containerLink2=link;
    }
  }
  ContainerState cont1=getDocument(ContainerState.class,containerLink1);
  ContainerState cont2=getDocument(ContainerState.class,containerLink2);
  assertNotNull(cont1);
  assertNotNull(cont2);
  assertTrue("Containers should be on the same host.",cont1.parentLink.equals(cont2.parentLink));
  ContainerVolumeState volume=getDocument(ContainerVolumeState.class,volumeLink);
  String volumeDescProp=volume.customProperties.get("volume propKey string");
  assertNotNull(volumeDescProp);
  assertEquals("volume customPropertyValue string",volumeDescProp);
  assertTrue("Volume is provisioned on wrong host.",volume.originatingHostLink.equals(cont1.parentLink));
  assertEquals(cont1.volumes.length,1);
  assertTrue("Host volume name is different than Container volume name.",cont1.volumes[0].contains(volume.name));
  assertTrue("Volume is provisioned on wrong host.",volume.originatingHostLink.equals(cont2.parentLink));
  assertEquals(cont2.volumes.length,1);
  assertTrue("Host volume name is different than Container volume name.",cont2.volumes[0].contains(volume.name));
}
