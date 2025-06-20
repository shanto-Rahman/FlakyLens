@Test public void shouldPreserveProcessorMetadataAfterTransform(){
assertTrue(Arrays.equals(new ResourceType[]{ResourceType.JS},decorator.getSupportedResourceTypes()));
assertTrue(decorator.isMinimize());
}