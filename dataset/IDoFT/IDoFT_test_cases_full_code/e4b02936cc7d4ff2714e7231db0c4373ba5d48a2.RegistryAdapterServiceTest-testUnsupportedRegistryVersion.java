@Test public void testUnsupportedRegistryVersion() throws Throwable {
  doDelete(UriUtils.buildUri(host,dockerHubRegistryStateLink),false);
  RegistryState registryState=new RegistryState();
  registryState.address="http://0.0.0.0";
  registryState.customProperties=new HashMap<>();
  registryState.customProperties.put(RegistryService.API_VERSION_PROP_NAME,"V99");
  String unsupportedRegistryStateLink=doPost(registryState,RegistryFactoryService.SELF_LINK).documentSelfLink;
  URI unsupportedRegistryStateUri=UriUtils.buildUri(host,unsupportedRegistryStateLink);
  ImageRequest request=new ImageRequest();
  request.operationTypeId=ImageOperationType.SEARCH.id;
  request.resourceReference=unsupportedRegistryStateUri;
  request.serviceTaskCallback=ServiceTaskCallback.create(provisioningTaskLink);
  request.customProperties=new HashMap<>();
  request.customProperties.put(RegistryAdapterService.SEARCH_QUERY_PROP_NAME,"foobar/vmware/admiral");
  Operation adapterOperation=Operation.createPatch(registryAdapterServiceUri).setReferer(host.getUri()).setBody(request).setCompletion((o,ex) -> {
    if (ex != null) {
      try {
        assertNotNull("Error message expected",ex.getMessage());
        assertTrue(ex.getMessage().contains("Unsupported registry version"));
        host.completeIteration();
      }
 catch (      AssertionError e) {
        host.failIteration(e);
      }
      return;
    }
    host.failIteration(new IllegalStateException("Failure expected."));
  }
);
  host.testStart(1);
  host.send(adapterOperation);
  host.testWait();
  MockTaskState provisioningTask=new MockTaskState();
  provisioningTaskLink=doPost(provisioningTask,MockTaskFactoryService.SELF_LINK).documentSelfLink;
  request=new ImageRequest();
  request.operationTypeId=ImageOperationType.LIST_TAGS.id;
  request.resourceReference=unsupportedRegistryStateUri;
  request.serviceTaskCallback=ServiceTaskCallback.create(provisioningTaskLink);
  request.customProperties=new HashMap<>();
  request.customProperties.put(RegistryAdapterService.SEARCH_QUERY_PROP_NAME,"foobar/vmware/admiral");
  adapterOperation=Operation.createPatch(registryAdapterServiceUri).setReferer(host.getUri()).setBody(request).setCompletion((o,ex) -> {
    if (ex != null) {
      try {
        assertNotNull("Error message expected",ex.getMessage());
        assertTrue(ex.getMessage().contains("Unsupported registry version"));
        host.completeIteration();
      }
 catch (      AssertionError e) {
        host.failIteration(e);
      }
      return;
    }
    host.failIteration(new IllegalStateException("Failure expected."));
  }
);
  host.testStart(1);
  host.send(adapterOperation);
  host.testWait();
}
