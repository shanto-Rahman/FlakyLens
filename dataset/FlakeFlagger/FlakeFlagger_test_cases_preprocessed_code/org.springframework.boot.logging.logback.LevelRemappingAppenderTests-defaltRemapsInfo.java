@Test public void defaltRemapsInfo() throws Exception {
assertThat(this.logCaptor.getValue().getLevel(),equalTo(Level.DEBUG));
}