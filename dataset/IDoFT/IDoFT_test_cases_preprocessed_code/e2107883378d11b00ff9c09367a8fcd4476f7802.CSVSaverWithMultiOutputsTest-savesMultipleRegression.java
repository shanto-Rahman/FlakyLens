@Test public void savesMultipleRegression() throws IOException {
assertEquals(before.getData(),after.getData());
assertEquals(before.getOutputIDInfo().size(),after.getOutputIDInfo().size());
assertEquals(before.getFeatureIDMap().size(),after.getFeatureIDMap().size());
}