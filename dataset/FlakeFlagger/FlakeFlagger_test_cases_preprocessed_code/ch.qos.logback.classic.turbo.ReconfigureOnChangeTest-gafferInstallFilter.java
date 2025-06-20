@Test public void gafferInstallFilter() throws JoranException, IOException, InterruptedException {
File file=new File(G_SCAN1_FILE_AS_STR);//RO
assertEquals(2,checker.matchCount("Will scan for changes in"));
}