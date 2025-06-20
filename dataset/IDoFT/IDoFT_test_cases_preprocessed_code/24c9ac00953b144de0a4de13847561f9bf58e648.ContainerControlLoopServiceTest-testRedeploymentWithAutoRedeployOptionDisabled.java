@Test public void testRedeploymentWithAutoRedeployOptionDisabled() throws Throwable {
if (healthyContainers != 0) {
}
if (healthyContainersFound.get()) {
fail("Should not have any healthy containers.");
}
}