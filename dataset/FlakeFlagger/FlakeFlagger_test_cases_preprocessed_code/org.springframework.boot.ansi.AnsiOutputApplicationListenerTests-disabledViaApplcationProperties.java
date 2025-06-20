@Test public void disabledViaApplcationProperties() throws Exception {
assertThat(AnsiOutput.getEnabled(),equalTo(Enabled.NEVER));
}