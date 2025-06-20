@Test public void testOnthrow() throws Exception {
assertThat(method.getOnthrow(),equalTo((Object)"on-throw-object"));
assertThat(attribute,hasEntry((Object)Constants.ON_THROW_INSTANCE_KEY,(Object)"on-throw-object"));
assertThat(parameters.size(),is(0));
}