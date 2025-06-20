@Test public void availabilityOfTemplateWithCustomPrefix(){
assertTrue(this.provider.isTemplateAvailable("prefixed",this.environment,getClass().getClassLoader(),this.resourceLoader));
}