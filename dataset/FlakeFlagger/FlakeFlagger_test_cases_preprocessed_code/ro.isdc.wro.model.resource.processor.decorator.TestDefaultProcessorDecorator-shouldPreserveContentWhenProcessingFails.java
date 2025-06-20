@Test public void shouldPreserveContentWhenProcessingFails() throws Exception {
Assert.assertEquals(resourceContent,writer.toString());
}