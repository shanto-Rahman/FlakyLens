@Test public void testEnhanceExtensibilityResponse() throws Throwable {
assertNotNull(selfLink);
assertNotNull(allocationTask);
assertEquals(1,allocationTask.resourceLinks.size());
assertNotNull(document);
assertNotNull(patchedHosts);
if (patchedHosts.size() == 4) {
assertEquals(beforeExtensibility.get(1).name,patchedHosts.get(2).name);
assertEquals(beforeExtensibility.get(0).name,patchedHosts.get(3).name);
}
}