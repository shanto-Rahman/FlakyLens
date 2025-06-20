@Test public void parseLevelsFails() throws Exception {
assertThat(this.outputCapture.toString(),not(containsString("testatdebug")));
assertThat(this.outputCapture.toString(),containsString("Cannot set level: GARBAGE"));
}