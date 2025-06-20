@Test public void testProcess() throws Exception {
assertFalse(this.transformer.hasTransformedResource());
assertTrue(this.transformer.hasTransformedResource());
}