@Test public void mvcError() throws Exception {
assertThat(this.errorAttributes.getError(this.requestAttributes),sameInstance((Object)ex));
assertThat(modelAndView,nullValue());
assertThat(attributes.get("exception"),equalTo((Object)RuntimeException.class.getName()));
assertThat(attributes.get("message"),equalTo((Object)"Test"));
}