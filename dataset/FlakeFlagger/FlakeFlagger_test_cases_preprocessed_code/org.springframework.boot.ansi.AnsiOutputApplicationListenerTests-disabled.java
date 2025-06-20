@Test public void disabled() throws Exception {
assertThat(AnsiOutput.getEnabled(),equalTo(Enabled.NEVER));
}