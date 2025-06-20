@Test public void shouldChangeSupportedTypesWhenInternalMethodIsOverriden(){
assertNull(null,new ProcessorDecorator(processor).getSupportedResourceType());
}