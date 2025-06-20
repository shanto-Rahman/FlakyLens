/** 
 * Will transform a cssless resource which was causing an infinite recursion. The test proves that transformation doesn't fail, though the transformed css is not valid anyway.
 */
@Test public void shouldHandleInvalidResources() throws IOException {
final File testFolder=new File(url.getFile(),"test");
final File expectedFolder=new File(url.getFile(),"expectedInvalid");
}