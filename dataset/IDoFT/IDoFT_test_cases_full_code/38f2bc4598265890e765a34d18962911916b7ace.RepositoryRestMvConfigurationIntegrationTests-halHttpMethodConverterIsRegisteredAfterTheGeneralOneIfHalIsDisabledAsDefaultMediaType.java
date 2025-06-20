@Test public void halHttpMethodConverterIsRegisteredAfterTheGeneralOneIfHalIsDisabledAsDefaultMediaType(){
  AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(NonHalConfiguration.class);
  CollectingComponent component=context.getBean(CollectingComponent.class);
  context.close();
  List<HttpMessageConverter<?>> converters=component.converters;
  assertThat(converters.get(0).getSupportedMediaTypes()).contains(RestMediaTypes.SCHEMA_JSON);
  assertThat(converters.get(1).getSupportedMediaTypes()).contains(MediaTypes.HAL_JSON);
}
