@Test public void testNgramModel(){
  NGramLanguageModel model=new NGramLanguageModel(4);
  model.add("I","saw","the","fox");
  model.add("the","red","house");
  model.add("I","saw","something","nice");
  double probability=model.calculateProbability("I","saw","the","red","house");
  Assert.assertTrue("a probability measure should be between 0 and 1 [was " + probability + "]",probability >= 0 && probability <= 1);
  String[] tokens=model.predictNextTokens("I","saw");
  Assert.assertNotNull(tokens);
  Assert.assertArrayEquals(new String[]{"the","fox"},tokens);
}
