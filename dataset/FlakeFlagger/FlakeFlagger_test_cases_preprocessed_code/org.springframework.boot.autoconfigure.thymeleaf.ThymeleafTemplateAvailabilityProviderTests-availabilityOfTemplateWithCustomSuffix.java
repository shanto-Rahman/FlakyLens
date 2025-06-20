@Test public void availabilityOfTemplateWithCustomSuffix(){
assertTrue(this.provider.isTemplateAvailable("suffixed",this.environment,getClass().getClassLoader(),this.resourceLoader));
}