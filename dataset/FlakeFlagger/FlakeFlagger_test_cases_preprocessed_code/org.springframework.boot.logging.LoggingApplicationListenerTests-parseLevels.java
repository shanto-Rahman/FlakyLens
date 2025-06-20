@Test public void parseLevels() throws Exception {
assertThat(this.outputCapture.toString(),containsString("testatdebug"));
assertThat(this.outputCapture.toString(),containsString("testattrace"));
}