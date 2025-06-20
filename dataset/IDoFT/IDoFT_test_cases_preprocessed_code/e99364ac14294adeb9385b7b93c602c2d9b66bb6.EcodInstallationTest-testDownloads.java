@Test public void testDownloads() throws IOException {
File domainsFile=new File(ecod2.getCacheLocation(),"ecod." + VERSION + ".domains.txt");
if (domainsFile.exists()) {
}
assertTrue("No downloaded file at " + domainsFile.toString(),domainsFile.exists());
}