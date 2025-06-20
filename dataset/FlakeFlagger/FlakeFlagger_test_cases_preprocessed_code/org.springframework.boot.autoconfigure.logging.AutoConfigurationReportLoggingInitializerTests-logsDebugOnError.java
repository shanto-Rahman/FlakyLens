@Test public void logsDebugOnError(){
fail("Did not error");
assertThat(this.debugLog.size(),not(equalTo(0)));
assertThat(this.infoLog.size(),equalTo(0));
}