@Test public void testQosEnable() throws Exception {
assertThat(application.getQosEnable(),is(true));
assertThat(parameters,hasEntry(Constants.QOS_ENABLE,"true"));
}