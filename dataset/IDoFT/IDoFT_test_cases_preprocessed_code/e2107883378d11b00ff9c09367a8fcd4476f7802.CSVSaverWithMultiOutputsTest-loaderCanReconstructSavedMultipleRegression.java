@Test public void loaderCanReconstructSavedMultipleRegression() throws IOException {
assertEquals(before.getData(),after.getData());
assertEquals(before.getOutputIDInfo().size(),after.getOutputIDInfo().size());
assertEquals(before.getFeatureIDMap().size(),after.getFeatureIDMap().size());
}