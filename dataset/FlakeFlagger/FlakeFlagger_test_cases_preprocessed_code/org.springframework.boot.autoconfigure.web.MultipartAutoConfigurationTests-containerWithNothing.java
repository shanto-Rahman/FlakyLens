@Test public void containerWithNothing(){
assertNotNull(servlet.getMultipartResolver());
assertThat(this.context.getBeansOfType(StandardServletMultipartResolver.class).size(),equalTo(1));
assertThat(this.context.getBeansOfType(MultipartResolver.class).size(),equalTo(1));
}