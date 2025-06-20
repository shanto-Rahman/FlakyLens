@Test public void testDuplicateRegistryInsideProjectShouldFail() throws Throwable {
fail("Should not be possible to add the same registry twice in the same scope");
assertTrue(e.getMessage().contains(RegistryFactoryService.REGISTRY_ALREADY_EXISTS));
}