@Test public void defaultApplicationContext() throws Exception {
assertThat(this.context,instanceOf(AnnotationConfigApplicationContext.class));
}