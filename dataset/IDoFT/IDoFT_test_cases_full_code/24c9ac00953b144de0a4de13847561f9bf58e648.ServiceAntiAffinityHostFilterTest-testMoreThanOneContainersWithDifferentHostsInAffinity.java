@Test public void testMoreThanOneContainersWithDifferentHostsInAffinity() throws Throwable {
  ContainerDescription desc1=createDescriptions(CONTAINER_NAME1);
  String hostLink1=initialHostLinks.get(0);
  createContainer(desc1,hostLink1);
  ContainerDescription desc2=createDescriptions(CONTAINER_NAME2);
  String hostLink2=initialHostLinks.get(1);
  createContainer(desc2,hostLink2);
  String[] anti_affinity=new String[]{ANTI_AFFINITY_PREFIX + CONTAINER_NAME1,ANTI_AFFINITY_PREFIX + CONTAINER_NAME2};
  ContainerDescription desc=createDescriptions(anti_affinity);
  filter=new ServiceAntiAffinityHostFilter(host,desc);
  expectedLinks.remove(hostLink1);
  expectedLinks.remove(hostLink2);
  filter(expectedLinks);
}
