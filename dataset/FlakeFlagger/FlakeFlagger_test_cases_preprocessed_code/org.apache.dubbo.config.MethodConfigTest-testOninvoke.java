@Test public void testOninvoke() throws Exception {
assertThat(method.getOninvoke(),equalTo((Object)"on-invoke-object"));
assertThat(attribute,hasEntry((Object)Constants.ON_INVOKE_INSTANCE_KEY,(Object)"on-invoke-object"));
assertThat(parameters.size(),is(0));
}