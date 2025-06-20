@Test public void noObjectMapperMeansNoConverter() throws Exception {
assertTrue(this.context.getBeansOfType(ObjectMapper.class).isEmpty());
assertTrue(this.context.getBeansOfType(MappingJackson2HttpMessageConverter.class).isEmpty());
assertTrue(this.context.getBeansOfType(MappingJackson2XmlHttpMessageConverter.class).isEmpty());
}