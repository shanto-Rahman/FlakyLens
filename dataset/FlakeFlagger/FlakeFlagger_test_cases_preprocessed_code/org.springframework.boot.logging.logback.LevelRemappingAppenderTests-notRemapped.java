@Test public void notRemapped() throws Exception {
assertThat(this.logCaptor.getAllValues().get(0).getLevel(),equalTo(Level.TRACE));
}