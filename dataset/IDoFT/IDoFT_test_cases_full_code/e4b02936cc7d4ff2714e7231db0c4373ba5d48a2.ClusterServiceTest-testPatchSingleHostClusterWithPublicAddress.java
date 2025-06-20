@Test public void testPatchSingleHostClusterWithPublicAddress() throws Throwable {
  final String name="test-cluster";
  final String details="test-details";
  final String patchedAddress="test-address";
  final String projectLink=buildProjectLink("test-vch-project");
  ContainerHostSpec hostSpec=createContainerHostSpec(Collections.singletonList(projectLink),ContainerHostType.VCH,name,details);
  ClusterDto cluster=createCluster(hostSpec);
  cluster=getOneCluster(Service.getId(cluster.documentSelfLink));
  assertNotNull(cluster);
  assertEquals(name,cluster.name);
  assertEquals(details,cluster.details);
  assertNull(cluster.publicAddress);
  ClusterDto patchClusterDto=new ClusterDto();
  patchClusterDto.publicAddress=patchedAddress;
  patchClusterDto.documentSelfLink=cluster.documentSelfLink;
  cluster=patchCluster(patchClusterDto);
  assertNotNull(patchClusterDto);
  assertEquals(patchedAddress,cluster.publicAddress);
  cluster=getOneCluster(Service.getId(cluster.documentSelfLink));
  assertNotNull(cluster);
  assertEquals(patchedAddress,cluster.publicAddress);
}
