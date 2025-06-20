@Test public void containsDefaults() throws Exception {
assertThat(converterClasses,equalTo(Arrays.<Class<?>>asList(ByteArrayHttpMessageConverter.class,StringHttpMessageConverter.class,ResourceHttpMessageConverter.class,SourceHttpMessageConverter.class,AllEncompassingFormHttpMessageConverter.class,MappingJackson2HttpMessageConverter.class,MappingJackson2XmlHttpMessageConverter.class)));
}