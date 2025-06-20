@Test public void savesMultiLabel() throws IOException {
  Set<String> responseNames=new HashSet<>(Arrays.asList("MONKEY","PUZZLE","TREE"));
  MultiLabelFactory factory=new MultiLabelFactory();
  MutableDataset<MultiLabel> before=new MutableDataset<>(null,factory);
  ArrayExample<MultiLabel> e=new ArrayExample<>(factory.generateOutput("MONKEY"));
  e.add(new Feature("A-MONKEY",1.0));
  e.add(new Feature("B-PUZZLE",0.0));
  e.add(new Feature("C-TREE",0.0));
  before.add(e);
  ArrayExample<MultiLabel> b=new ArrayExample<>(factory.generateOutput("MONKEY,TREE"));
  b.add(new Feature("A-MONKEY",1.0));
  b.add(new Feature("C-TREE",1.0));
  CSVSaver saver=new CSVSaver();
  File tmpFile=File.createTempFile("tribuo-csv-test","csv");
  tmpFile.deleteOnExit();
  Path tmp=tmpFile.toPath();
  saver.save(tmp,before,responseNames);
  CSVLoader<MultiLabel> loader=new CSVLoader<>(factory);
  MutableDataset<MultiLabel> after=loader.load(tmp,responseNames);
  assertEquals(before.getData(),after.getData());
  assertEquals(before.getOutputIDInfo().size(),after.getOutputIDInfo().size());
  assertEquals(before.getFeatureIDMap().size(),after.getFeatureIDMap().size());
}
