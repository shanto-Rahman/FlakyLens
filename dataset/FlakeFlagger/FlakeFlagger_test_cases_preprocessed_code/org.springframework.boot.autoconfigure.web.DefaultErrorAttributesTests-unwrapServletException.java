@Test public void unwrapServletException() throws Exception {
assertThat(this.errorAttributes.getError(this.requestAttributes),sameInstance((Object)wrapped));
assertThat(attributes.get("exception"),equalTo((Object)RuntimeException.class.getName()));
assertThat(attributes.get("message"),equalTo((Object)"Test"));
}