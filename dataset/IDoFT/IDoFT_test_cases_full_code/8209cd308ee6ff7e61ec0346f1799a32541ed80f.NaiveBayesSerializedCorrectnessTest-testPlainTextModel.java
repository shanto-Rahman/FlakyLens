@Test public void testPlainTextModel() throws IOException {
  testDataIndexer.index(NaiveBayesCorrectnessTest.createTrainingStream());
  NaiveBayesModel model1=(NaiveBayesModel)new NaiveBayesTrainer().trainModel(testDataIndexer);
  StringWriter sw1=new StringWriter();
  NaiveBayesModelWriter modelWriter=new PlainTextNaiveBayesModelWriter(model1,new BufferedWriter(sw1));
  modelWriter.persist();
  NaiveBayesModelReader reader=new PlainTextNaiveBayesModelReader(new BufferedReader(new StringReader(sw1.toString())));
  reader.checkModelType();
  NaiveBayesModel model2=(NaiveBayesModel)reader.constructModel();
  StringWriter sw2=new StringWriter();
  modelWriter=new PlainTextNaiveBayesModelWriter(model2,new BufferedWriter(sw2));
  modelWriter.persist();
  System.out.println(sw1.toString());
  Assert.assertEquals(sw1.toString(),sw2.toString());
}
