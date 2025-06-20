/** 
 * Test that processing invalid sass css produces exceptions.
 */
@Test public void shouldFailWhenInvalidSassCssIsProcessed() throws Exception {
final File testFolder=new File(url.getFile(),"invalid");
processor.process(null,new FileReader(input),new StringWriter());
fail("Shouldn't have failed");
}