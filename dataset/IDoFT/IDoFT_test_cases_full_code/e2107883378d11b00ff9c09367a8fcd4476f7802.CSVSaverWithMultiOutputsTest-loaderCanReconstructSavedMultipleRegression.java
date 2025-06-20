@Test public void loaderCanReconstructSavedMultipleRegression() throws IOException {
  Path path=Resources.copyResourceToTmp("/org/tribuo/tests/csv/multioutput-regression.csv");
  Set<String> responses=new HashSet<>(Arrays.asList("R1","R2"));
  CSVLoader<Regressor> loader=new CSVLoader<>(new RegressionFactory());
  Dataset<Regressor> before=loader.load(path,responses);
  File tmpFile=File.createTempFile("tribuo-csv-test","csv");
  tmpFile.deleteOnExit();
  Path tmp=tmpFile.toPath();
  new CSVSaver().save(tmp,before,responses);
  Dataset<Regressor> after=loader.load(tmp,responses);
  assertEquals(before.getData(),after.getData());
  assertEquals(before.getOutputIDInfo().size(),after.getOutputIDInfo().size());
  assertEquals(before.getFeatureIDMap().size(),after.getFeatureIDMap().size());
}
