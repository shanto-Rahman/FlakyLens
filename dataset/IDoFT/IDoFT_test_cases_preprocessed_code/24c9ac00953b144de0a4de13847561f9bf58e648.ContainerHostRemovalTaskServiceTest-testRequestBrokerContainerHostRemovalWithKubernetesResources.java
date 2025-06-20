@Test public void testRequestBrokerContainerHostRemovalWithKubernetesResources() throws Throwable {
assertTrue("PodState links not removed: " + podStateLinks,podStateLinks.isEmpty());
assertTrue("ServiceState links not removed: " + serviceStateLinks,serviceStateLinks.isEmpty());
assertTrue("ComputeState was not deleted: " + computeSelfLinks,computeSelfLinks.isEmpty());
}