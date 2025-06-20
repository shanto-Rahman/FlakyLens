/** 
 * Test that processing invalid less css produces exceptions
 */
@Test public void shouldFailWhenInvalidLessCssIsProcessed() throws Exception {
final File testFolder=new File(url.getFile(),"invalid");
processor.process(null,new FileReader(input),new StringWriter());
Assert.fail("Expected to fail, but didn't");
}