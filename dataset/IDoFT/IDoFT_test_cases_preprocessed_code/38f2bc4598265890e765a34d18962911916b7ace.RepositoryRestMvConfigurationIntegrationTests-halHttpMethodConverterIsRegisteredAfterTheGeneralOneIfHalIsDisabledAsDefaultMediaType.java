@Test public void halHttpMethodConverterIsRegisteredAfterTheGeneralOneIfHalIsDisabledAsDefaultMediaType(){
AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(NonHalConfiguration.class);//RW
CollectingComponent component=context.getBean(CollectingComponent.class);//RW
context.close();//RW
assertThat(converters.get(0).getSupportedMediaTypes()).contains(RestMediaTypes.SCHEMA_JSON);
assertThat(converters.get(1).getSupportedMediaTypes()).contains(MediaTypes.HAL_JSON);
}