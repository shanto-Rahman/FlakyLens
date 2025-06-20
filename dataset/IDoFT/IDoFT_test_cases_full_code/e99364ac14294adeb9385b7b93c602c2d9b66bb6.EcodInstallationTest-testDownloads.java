@Test public void testDownloads() throws IOException {
  EcodInstallation ecod2=new EcodInstallation(tmpFolder.getRoot().getAbsolutePath(),VERSION);
  File domainsFile=new File(ecod2.getCacheLocation(),"ecod." + VERSION + ".domains.txt");
  if (domainsFile.exists()) {
    domainsFile.delete();
  }
  ecod2.ensureDomainsFileInstalled();
  assertTrue("No downloaded file at " + domainsFile.toString(),domainsFile.exists());
}
