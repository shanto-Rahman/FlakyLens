@Test public void testOninvokeMethod() throws Exception {
assertThat(method.getOninvokeMethod(),equalTo("on-invoke-method"));
assertThat(attribute,hasEntry((Object)Constants.ON_INVOKE_METHOD_KEY,(Object)"on-invoke-method"));
assertThat(parameters.size(),is(0));
}