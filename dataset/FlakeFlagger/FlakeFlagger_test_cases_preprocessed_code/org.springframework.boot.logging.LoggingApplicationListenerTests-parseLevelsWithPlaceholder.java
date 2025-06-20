@Test public void parseLevelsWithPlaceholder() throws Exception {
assertThat(this.outputCapture.toString(),containsString("testatdebug"));
assertThat(this.outputCapture.toString(),containsString("testattrace"));
}