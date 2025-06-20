@Test public void testBuildAndSearchComplexPermutationIndex(){
  int peterRank=positionalBuildSearchGetRank("-dimension 200 -vectortype complex -seedlength 10 -positionalmethod permutation -luceneindexpath positional_index","-searchtype permutation -queryvectorfile elementalvectors.bin -searchvectorfile permtermvectors.bin simon ?",new String[]{"elementalvectors.bin","permtermvectors.bin","docvectors.bin"},"peter");
  assertTrue(peterRank < 3);
}
