@Test public void defaultDataDir(){
assertThat(configuration.getJournalDirectory(),startsWith(System.getProperty("java.io.tmpdir")));
assertThat(configuration.getJournalDirectory(),endsWith("/journal"));
}