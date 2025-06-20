@Test public void duplicateGrabMetadataAnnotationsProducesAnError() throws Exception {
fail();
assertThat(ex.getMessage(),containsString("Duplicate @GrabMetadata annotation"));
}