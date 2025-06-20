@Test public void testHeterogeneousMultiLabelExport() throws IOException, OrtException {
  DataSource<MultiLabel> trainSource=MultiLabelGaussianDataSource.makeDefaultSource(100,1L);
  MutableDataset<MultiLabel> train=new MutableDataset<>(trainSource);
  DataSource<MultiLabel> testSource=MultiLabelGaussianDataSource.makeDefaultSource(100,2L);
  MutableDataset<MultiLabel> test=new MutableDataset<>(testSource);
  BinaryCrossEntropy loss=new BinaryCrossEntropy();
  AdaGrad adagrad=new AdaGrad(0.1,0.1);
  org.tribuo.multilabel.sgd.linear.LinearSGDTrainer lr=new org.tribuo.multilabel.sgd.linear.LinearSGDTrainer(loss,adagrad,3,1000,1,1L);
  BaggingTrainer<MultiLabel> t=new BaggingTrainer<>(lr,ML_VOTING,5);
  EnsembleModel<MultiLabel> bagModel=t.train(train);
  FMMultiLabelTrainer fmT=new FMMultiLabelTrainer(loss,adagrad,2,100,1,1L,5,0.1);
  AbstractFMModel<MultiLabel> fmModel=fmT.train(train);
  WeightedEnsembleModel<MultiLabel> ensemble=WeightedEnsembleModel.createEnsembleFromExistingModels("Bag+FM",Arrays.asList(bagModel,fmModel),ML_VOTING,new float[]{0.3f,0.7f});
  Path onnxFile=Files.createTempFile("tribuo-bagging-test",".onnx");
  ensemble.saveONNXModel("org.tribuo.ensemble.test",1,onnxFile);
  OnnxTestUtils.onnxMultiLabelComparison(ensemble,onnxFile,test,1e-6);
  onnxFile.toFile().delete();
}
