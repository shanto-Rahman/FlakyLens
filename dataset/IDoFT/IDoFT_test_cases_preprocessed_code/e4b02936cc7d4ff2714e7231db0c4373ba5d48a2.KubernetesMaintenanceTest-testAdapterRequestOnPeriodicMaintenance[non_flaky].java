@Test public void testAdapterRequestOnPeriodicMaintenance() throws Throwable {
assertNotNull(MockKubernetesAdapterService.requestOnInspect);
assertEquals(KubernetesOperationType.INSPECT.id,MockKubernetesAdapterService.requestOnInspect.operationTypeId);
assertEquals(podState.documentSelfLink,MockKubernetesAdapterService.requestOnInspect.resourceReference.getPath());
}