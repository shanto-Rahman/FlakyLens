@Test public void testBadRequest() throws Throwable {
  Operation adapterOperation=Operation.createPatch(registryAdapterServiceUri).setReferer(host.getUri()).setCompletion((o,ex) -> {
    if (ex != null) {
      assertNotNull("Error message expected",ex.getMessage());
      assertTrue(ex instanceof IllegalArgumentException);
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
