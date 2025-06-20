@Test public void testUsername() throws Exception {
assertThat(monitor.getUsername(),equalTo("user"));
assertThat(parameters.isEmpty(),is(true));
}