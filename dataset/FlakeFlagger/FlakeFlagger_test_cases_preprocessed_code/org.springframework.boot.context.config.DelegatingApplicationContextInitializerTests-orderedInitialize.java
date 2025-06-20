@Test public void orderedInitialize() throws Exception {
assertThat(context.getBeanFactory().getSingleton("a"),equalTo((Object)"a"));
assertThat(context.getBeanFactory().getSingleton("b"),equalTo((Object)"b"));
}