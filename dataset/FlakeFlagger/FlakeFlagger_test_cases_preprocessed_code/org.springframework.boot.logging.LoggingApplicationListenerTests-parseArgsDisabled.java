@Test public void parseArgsDisabled() throws Exception {
assertThat(this.outputCapture.toString(),not(containsString("testatdebug")));
}