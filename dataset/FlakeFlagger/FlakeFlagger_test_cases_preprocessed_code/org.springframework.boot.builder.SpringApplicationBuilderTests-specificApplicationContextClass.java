@Test public void specificApplicationContextClass() throws Exception {
assertThat(this.context,is(instanceOf(StaticApplicationContext.class)));
}