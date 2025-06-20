@Test public void defaultApplicationContextForWeb() throws Exception {
assertThat(this.context,instanceOf(AnnotationConfigEmbeddedWebApplicationContext.class));
}