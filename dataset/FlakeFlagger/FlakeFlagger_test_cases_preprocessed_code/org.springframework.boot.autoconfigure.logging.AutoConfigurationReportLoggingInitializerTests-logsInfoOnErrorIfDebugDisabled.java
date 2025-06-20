@Test public void logsInfoOnErrorIfDebugDisabled(){
fail("Did not error");
assertThat(this.debugLog.size(),equalTo(0));
assertThat(this.infoLog.size(),not(equalTo(0)));
}