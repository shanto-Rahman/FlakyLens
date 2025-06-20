@Test public void parseLevelsNone() throws Exception {
assertThat(this.outputCapture.toString(),not(containsString("testatdebug")));
assertThat(this.outputCapture.toString(),not(containsString("testatfatal")));
}