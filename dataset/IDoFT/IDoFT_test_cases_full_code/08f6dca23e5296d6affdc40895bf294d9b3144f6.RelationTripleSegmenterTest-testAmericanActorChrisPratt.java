public void testAmericanActorChrisPratt(){
  String conll="1\tAmerican\t4\tamod\tNN\tLOCATION\n" + "2\tactor\t4\tcompound\tNN\tTITLE\n" + "3\tChris\t4\tcompound\tNNP\tPERSON\n"+ "4\tPratt\t0\troot\tNNP\tPERSON\n";
  Optional<RelationTriple> extraction=mkExtraction(conll,0);
  assertTrue("No first extraction for sentence!",extraction.isPresent());
  assertEquals("1.0\tChris Pratt\tis actor of\tAmerican",extraction.get().toString());
  extraction=mkExtraction(conll,1);
  assertTrue("No second extraction for sentence!",extraction.isPresent());
  assertEquals("1.0\tChris Pratt\tis\tAmerican",extraction.get().toString());
  extraction=mkExtraction(conll,2);
  assertTrue("No third extraction for sentence!",extraction.isPresent());
  assertEquals("1.0\tChris Pratt\tis\tactor",extraction.get().toString());
}
