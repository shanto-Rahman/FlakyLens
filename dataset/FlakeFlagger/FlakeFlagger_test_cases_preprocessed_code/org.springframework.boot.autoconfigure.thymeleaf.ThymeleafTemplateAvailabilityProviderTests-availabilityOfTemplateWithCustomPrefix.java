@Test public void availabilityOfTemplateWithCustomPrefix(){
assertTrue(this.provider.isTemplateAvailable("custom",this.environment,getClass().getClassLoader(),this.resourceLoader));
}