@Test public void testSameRegistryTwoDifferentProjectsNotRemoveOldTenantLinkShouldFail() throws Throwable {
fail("Should not be possible to add the same registry in two different projects");
assertTrue(e.getMessage().contains(RegistryFactoryService.REGISTRY_ALREADY_EXISTS));
}