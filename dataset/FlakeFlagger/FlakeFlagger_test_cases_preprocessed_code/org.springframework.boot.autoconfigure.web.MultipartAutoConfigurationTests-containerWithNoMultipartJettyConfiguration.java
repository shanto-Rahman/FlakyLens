@Test public void containerWithNoMultipartJettyConfiguration(){
assertNotNull(servlet.getMultipartResolver());
assertThat(this.context.getBeansOfType(StandardServletMultipartResolver.class).size(),equalTo(1));
assertThat(this.context.getBeansOfType(MultipartResolver.class).size(),equalTo(1));
}