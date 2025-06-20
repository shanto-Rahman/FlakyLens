/** 
 * Constructor test specifying Factory and using a evalue threshold filter
 */
@Test public void testConstructorWithEvalueHspFilter(){
  String resource="/org/biojava/nbio/core/search/io/blast/testBlastReport.blastxml";
  URL resourceURL=getClass().getResource(resource);
  File file=new File(resourceURL.getFile());
  ResultFactory blastResultFactory=new BlastXMLParser();
  final SearchIO instance;
  try {
    instance=new SearchIO(file,blastResultFactory,10e-10);
  }
 catch (  Exception e) {
    fail("test failed:\n" + e.getMessage());
  }
}
