/** 
 * Constructor test specifying Factory
 */
@Test public void testConstructorWithoutFactoryGuess(){
  String resource="/org/biojava/nbio/core/search/io/blast/testBlastReport.blastxml";
  URL resourceURL=getClass().getResource(resource);
  File file=new File(resourceURL.getFile());
  ResultFactory blastResultFactory=new BlastXMLParser();
  final SearchIO instance;
  try {
    instance=new SearchIO(file,blastResultFactory);
  }
 catch (  Exception e) {
    fail("test failed:\n" + e.getMessage());
  }
}
