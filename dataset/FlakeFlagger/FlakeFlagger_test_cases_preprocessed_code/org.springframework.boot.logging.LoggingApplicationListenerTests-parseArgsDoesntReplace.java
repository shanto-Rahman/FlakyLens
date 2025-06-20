@Test public void parseArgsDoesntReplace() throws Exception {
assertThat(this.outputCapture.toString(),not(containsString("testatdebug")));
}