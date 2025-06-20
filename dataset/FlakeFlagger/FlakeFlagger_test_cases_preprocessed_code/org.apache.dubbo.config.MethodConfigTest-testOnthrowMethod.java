@Test public void testOnthrowMethod() throws Exception {
assertThat(method.getOnthrowMethod(),equalTo("on-throw-method"));
assertThat(attribute,hasEntry((Object)Constants.ON_THROW_METHOD_KEY,(Object)"on-throw-method"));
assertThat(parameters.size(),is(0));
}