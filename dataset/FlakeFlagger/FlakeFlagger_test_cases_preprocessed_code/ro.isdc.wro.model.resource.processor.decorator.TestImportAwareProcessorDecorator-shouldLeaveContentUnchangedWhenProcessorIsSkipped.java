@Test public void shouldLeaveContentUnchangedWhenProcessorIsSkipped() throws Exception {
Assert.assertEquals(resourceContent,writer.toString());
}