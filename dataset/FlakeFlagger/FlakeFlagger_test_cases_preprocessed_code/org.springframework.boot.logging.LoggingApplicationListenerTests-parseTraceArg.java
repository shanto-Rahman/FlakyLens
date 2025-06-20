@Test public void parseTraceArg() throws Exception {
assertThat(this.outputCapture.toString(),containsString("testatdebug"));
assertThat(this.outputCapture.toString(),containsString("testattrace"));
}