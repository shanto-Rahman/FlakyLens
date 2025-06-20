/** 
 * Test a simple swap to disk / swap from disk operation.  Configured to use  {@link StaticKeyProvider}.
 */
@Test public void testSwapOutSwapIn() throws GeneralSecurityException, IOException {
new File(folderRepository,"swap").deleteOnExit();
Assert.assertEquals(flowFiles.size(),flowFilesRecovered.size());
Assert.assertTrue(flowFilesRecovered.containsAll(flowFiles));
Assert.assertTrue(flowFiles.containsAll(flowFilesRecovered));
}