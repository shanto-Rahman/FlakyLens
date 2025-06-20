@Test public void getNonRecursiveEntriesForRoot() throws Exception {
ExplodedArchive archive=new ExplodedArchive(new File("/"),false);//RO
assertThat(entries.size(),greaterThan(1));
}