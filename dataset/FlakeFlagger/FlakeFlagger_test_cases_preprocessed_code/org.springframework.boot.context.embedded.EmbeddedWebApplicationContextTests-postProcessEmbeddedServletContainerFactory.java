@Test public void postProcessEmbeddedServletContainerFactory() throws Exception {
assertThat(getEmbeddedServletContainerFactory().getContainer().getPort(),equalTo(8080));
}