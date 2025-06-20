@Test public void testOnreturnMethod() throws Exception {
assertThat(method.getOnreturnMethod(),equalTo("on-return-method"));
assertThat(attribute,hasEntry((Object)Constants.ON_RETURN_METHOD_KEY,(Object)"on-return-method"));
assertThat(parameters.size(),is(0));
}