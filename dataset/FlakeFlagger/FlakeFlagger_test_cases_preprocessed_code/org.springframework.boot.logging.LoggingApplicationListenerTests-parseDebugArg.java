@Test public void parseDebugArg() throws Exception {
assertThat(this.outputCapture.toString(),containsString("testatdebug"));
assertThat(this.outputCapture.toString(),not(containsString("testattrace")));
}