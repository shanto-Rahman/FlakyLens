@Test public void postProcessConverters() throws Exception {
if (iterator.next() instanceof MappingJackson2XmlHttpMessageConverter) {
}
assertThat(converterClasses,equalTo(Arrays.<Class<?>>asList(ByteArrayHttpMessageConverter.class,StringHttpMessageConverter.class,ResourceHttpMessageConverter.class,SourceHttpMessageConverter.class,AllEncompassingFormHttpMessageConverter.class,MappingJackson2HttpMessageConverter.class)));
}