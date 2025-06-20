@Test public void loaderCanReconstructSavedMultiLabel() throws IOException {
assertEquals(before.getData(),after.getData());
assertEquals(before.getOutputIDInfo().size(),after.getOutputIDInfo().size());
assertEquals(before.getFeatureIDMap().size(),after.getFeatureIDMap().size());
}