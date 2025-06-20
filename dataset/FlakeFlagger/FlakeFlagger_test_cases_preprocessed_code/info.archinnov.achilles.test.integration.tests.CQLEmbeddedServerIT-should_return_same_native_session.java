@Test public void should_return_same_native_session() throws Exception {
assertThat(session).isSameAs(this.session);
}