@Test public void customRemaps() throws Exception {
assertThat(this.logCaptor.getAllValues().get(0).getLevel(),equalTo(Level.TRACE));
assertThat(this.logCaptor.getAllValues().get(1).getLevel(),equalTo(Level.WARN));
}