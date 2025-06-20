/** 
 * Test that processing invalid less css produces exceptions
 */
@Test public void shouldFailWhenInvalidTypeScriptIsProcessed() throws Exception {
final File testFolder=new File(url.getFile(),"invalid");
decorated.process(Resource.create(input.getPath(),ResourceType.JS),new FileReader(input),new StringWriter());
Assert.fail("Expected to fail, but didn't");
}