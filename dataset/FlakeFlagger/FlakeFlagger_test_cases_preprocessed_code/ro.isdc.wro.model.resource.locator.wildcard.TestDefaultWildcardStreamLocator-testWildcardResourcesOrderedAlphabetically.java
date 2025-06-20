@Test public void testWildcardResourcesOrderedAlphabetically() throws IOException {
Assert.assertEquals(Arrays.toString(new String[]{"tools.expose-1.0.5.js","tools.overlay-1.1.2.js","tools.overlay.apple-1.0.1.js","tools.overlay.gallery-1.0.0.js"}),Arrays.toString(filenameList.toArray()));
}