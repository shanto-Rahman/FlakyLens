@Test public void tooLargeDataFrame() throws IOException {
fail();
assertEquals("FRAME_SIZE_ERROR length > 16383: 16777216",e.getMessage());
}