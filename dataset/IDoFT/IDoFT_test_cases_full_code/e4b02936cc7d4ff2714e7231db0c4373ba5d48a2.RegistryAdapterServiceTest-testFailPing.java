@Test public void testFailPing() throws Throwable {
  ImageRequest request=new ImageRequest();
  request.operationTypeId=ImageOperationType.PING.id;
  request.resourceReference=host.getUri();
  request.serviceTaskCallback=ServiceTaskCallback.create(provisioningTaskLink);
  request.customProperties=new HashMap<>();
  Operation adapterOperation=Operation.createPatch(registryAdapterServiceUri).setReferer(host.getUri()).setBody(request).setCompletion((o,ex) -> {
    if (ex != null) {
      assertNotNull("Error message expected",ex.getMessage());
      assertTrue(ex.getMessage().contains("Ping attempts failed with errors"));
      host.completeIteration();
      return;
    }
    host.failIteration(new IllegalStateException("Failure expected."));
  }
);
  host.testStart(1);
  host.send(adapterOperation);
  host.testWait();
}
