@Test public void loaderCanReconstructSavedMultiLabel() throws IOException {
  Path path=Resources.copyResourceToTmp("/org/tribuo/tests/csv/multilabel.csv");
  Set<String> responses=new HashSet<>(Arrays.asList("R1","R2"));
  CSVLoader<MultiLabel> loader=new CSVLoader<>(new MultiLabelFactory());
  MutableDataset<MultiLabel> before=loader.load(path,responses);
  File tmpFile=File.createTempFile("tribuo-csv-test","csv");
  tmpFile.deleteOnExit();
  Path tmp=tmpFile.toPath();
  new CSVSaver().save(tmp,before,responses);
  MutableDataset<MultiLabel> after=loader.load(tmp,responses);
  assertEquals(before.getData(),after.getData());
  assertEquals(before.getOutputIDInfo().size(),after.getOutputIDInfo().size());
  assertEquals(before.getFeatureIDMap().size(),after.getFeatureIDMap().size());
}
