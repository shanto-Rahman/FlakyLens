@Test public void testProvisionContainerWhenAnotherAlreadyProvisionedAndHasVolumesFromRules() throws Throwable {
assertEquals(UriUtils.buildUriPath(CompositeComponentFactoryService.SELF_LINK,state.contextId),container.compositeComponentLink);
if (e != null) {
fail("Unexpected exception: " + e);
}
}