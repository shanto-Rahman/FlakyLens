@Test public void testPassword() throws Exception {
assertThat(monitor.getPassword(),equalTo("secret"));
assertThat(parameters.isEmpty(),is(true));
}