@Test public void savesMultiLabel() throws IOException {
assertEquals(before.getData(),after.getData());
assertEquals(before.getOutputIDInfo().size(),after.getOutputIDInfo().size());
assertEquals(before.getFeatureIDMap().size(),after.getFeatureIDMap().size());
}