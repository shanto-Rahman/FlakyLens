@Test public void testRequestStateHasK8sInfo() throws Throwable {
  ResourcePoolState resourcePool=createResourcePool();
  createKubernetesHost(resourcePool);
  GroupResourcePlacementState groupPlacementState=createGroupResourcePlacement(resourcePool);
  String template=CommonTestStateFactory.getFileContent(WP_K8S_TEMPLATE);
  CompositeDescription cd=createCompositeFromYaml(template);
  cd.tenantLinks=groupPlacementState.tenantLinks;
  cd=doPut(cd);
  assertDocumentsCount(0,DeploymentService.DeploymentState.class);
  RequestBrokerState request=TestRequestStateFactory.createRequestState();
  request.resourceType=ResourceType.COMPOSITE_COMPONENT_TYPE.getName();
  request.resourceDescriptionLink=cd.documentSelfLink;
  request.groupResourcePlacementLink=groupPlacementState.documentSelfLink;
  request.tenantLinks=groupPlacementState.tenantLinks;
  request=startRequest(request);
  request=waitForRequestToComplete(request);
  RequestStatus rs=getDocument(RequestStatus.class,request.requestTrackerLink);
  assertNotNull(rs);
  assertNotNull(rs.resourceLinks);
  long numberOfDeployments=YamlMapper.splitYaml(template).stream().filter(entity -> entity.contains(KubernetesUtil.DEPLOYMENT_TYPE)).count();
  assertEquals(1,MockKubernetesApplicationAdapterService.getProvisionedComponents().size());
  assertEquals(numberOfDeployments,MockKubernetesApplicationAdapterService.getCreatedDeploymentStates().size());
  assertEquals(numberOfDeployments,rs.resourceLinks.size());
  assertTrue(rs.resourceLinks.stream().allMatch(l -> l.contains(ManagementUriParts.KUBERNETES_DEPLOYMENTS)));
  assertDocumentsCount(numberOfDeployments,DeploymentService.DeploymentState.class);
  assertRightResourceLinks(rs.resourceLinks,DeploymentService.DeploymentState.class);
  assertDeploymentAreFromTheSameCompositeComponent();
}
