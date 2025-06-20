@Test public void testSelectHostExistingContainerWithLinkNoAlias() throws Throwable {
  CompositeComponent component=createComponent("App-With-Links-Test");
  ContainerDescription desc1=createDescription("mysql",null);
  ContainerDescription desc2=createDescription("wordpress",new String[]{"mysql"});
  createContainer(component,desc1);
  createContainer(component,desc2);
  String contextId=extractId(component.documentSelfLink);
  state.contextId=contextId;
  state.addCustomProperty(RequestUtils.FIELD_NAME_CONTEXT_ID_KEY,contextId);
  state.addCustomProperty(RequestUtils.CLUSTERING_OPERATION_CUSTOM_PROP,"true");
  filter=new ClusterServiceLinkAffinityHostFilter(host,desc1);
  expectedLinks=Arrays.asList(initialHostLinks.get(0));
  Throwable e=filter(expectedLinks);
  if (e != null) {
    fail("Unexpected exception: " + e);
  }
}
