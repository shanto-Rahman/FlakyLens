@Test public void orderedInitialize() throws Exception {
assertThat(this.context.getBeanFactory().getSingleton("a"),equalTo((Object)"a"));
assertThat(this.context.getBeanFactory().getSingleton("b"),equalTo((Object)"b"));
}