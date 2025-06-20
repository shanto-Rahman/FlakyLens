@Test public void testOnreturn() throws Exception {
assertThat(method.getOnreturn(),equalTo((Object)"on-return-object"));
assertThat(attribute,hasEntry((Object)Constants.ON_RETURN_INSTANCE_KEY,(Object)"on-return-object"));
assertThat(parameters.size(),is(0));
}