@Test public void specificApplicationContextClass() throws Exception {
assertThat(this.context,instanceOf(StaticApplicationContext.class));
}