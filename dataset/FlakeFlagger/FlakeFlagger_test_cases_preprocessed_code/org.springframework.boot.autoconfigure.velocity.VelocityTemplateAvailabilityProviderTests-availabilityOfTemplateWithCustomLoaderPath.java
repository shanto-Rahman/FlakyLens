@Test public void availabilityOfTemplateWithCustomLoaderPath(){
assertTrue(this.provider.isTemplateAvailable("custom",this.environment,getClass().getClassLoader(),this.resourceLoader));
}