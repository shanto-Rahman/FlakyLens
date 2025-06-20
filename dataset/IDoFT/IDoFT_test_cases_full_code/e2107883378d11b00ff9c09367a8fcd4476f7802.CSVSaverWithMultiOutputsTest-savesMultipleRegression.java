@Test public void savesMultipleRegression() throws IOException {
  String[] vars=new String[]{"dim1","dim2"};
  Set<String> responseNames=new HashSet<>(Arrays.asList("dim1","dim2"));
  RegressionFactory factory=new RegressionFactory();
  MutableDataset<Regressor> before=new MutableDataset<>(null,factory);
  ArrayExample<Regressor> e=new ArrayExample<>(new Regressor(vars,new double[]{0.1,0.0}));
  e.add(new Feature("A",1.0));
  e.add(new Feature("B",0.0));
  e.add(new Feature("C",0.0));
  before.add(e);
  ArrayExample<Regressor> b=new ArrayExample<>(new Regressor(vars,new double[]{0.0,0.0}));
  b.add(new Feature("A",1.0));
  b.add(new Feature("B",0.0));
  b.add(new Feature("C",0.1));
  before.add(b);
  CSVSaver saver=new CSVSaver();
  File tmpFile=File.createTempFile("tribuo-csv-test","csv");
  tmpFile.deleteOnExit();
  Path tmp=tmpFile.toPath();
  saver.save(tmp,before,responseNames);
  CSVLoader<Regressor> loader=new CSVLoader<>(factory);
  MutableDataset<Regressor> after=loader.load(tmp,responseNames);
  assertEquals(before.getData(),after.getData());
  assertEquals(before.getOutputIDInfo().size(),after.getOutputIDInfo().size());
  assertEquals(before.getFeatureIDMap().size(),after.getFeatureIDMap().size());
}
