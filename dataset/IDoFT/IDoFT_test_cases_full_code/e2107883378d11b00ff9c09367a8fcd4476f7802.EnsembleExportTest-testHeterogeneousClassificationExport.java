@Test public void testHeterogeneousClassificationExport() throws IOException, OrtException {
  DataSource<Label> trainSource=new NoisyInterlockingCrescentsDataSource(100,1,0.1);
  MutableDataset<Label> train=new MutableDataset<>(trainSource);
  DataSource<Label> testSource=new NoisyInterlockingCrescentsDataSource(100,2,0.1);
  MutableDataset<Label> test=new MutableDataset<>(testSource);
  AdaGrad adagrad=new AdaGrad(0.1,0.1);
  LogisticRegressionTrainer lr=new LogisticRegressionTrainer();
  BaggingTrainer<Label> t=new BaggingTrainer<>(lr,VOTING,5);
  EnsembleModel<Label> bagModel=t.train(train);
  FMClassificationTrainer fmT=new FMClassificationTrainer(new LogMulticlass(),adagrad,2,100,1,1L,5,0.1);
  AbstractFMModel<Label> fmModel=fmT.train(train);
  LibSVMClassificationTrainer svmT=new LibSVMClassificationTrainer(new SVMParameters<>(new SVMClassificationType(SVMClassificationType.SVMMode.NU_SVC),KernelType.RBF));
  LibSVMClassificationModel svmModel=(LibSVMClassificationModel)svmT.train(train);
  WeightedEnsembleModel<Label> ensemble=WeightedEnsembleModel.createEnsembleFromExistingModels("Bag+FM",Arrays.asList(bagModel,fmModel,svmModel),FULL_VOTING,new float[]{0.3f,0.5f,0.2f});
  Path onnxFile=Files.createTempFile("tribuo-bagging-test",".onnx");
  ensemble.saveONNXModel("org.tribuo.ensemble.test",1,onnxFile);
  OnnxTestUtils.onnxLabelComparison(ensemble,onnxFile,test,1e-6);
  onnxFile.toFile().delete();
}
