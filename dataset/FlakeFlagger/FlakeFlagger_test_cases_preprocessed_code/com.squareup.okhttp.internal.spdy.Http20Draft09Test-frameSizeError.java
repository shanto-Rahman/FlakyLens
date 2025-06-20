@Test public void frameSizeError() throws IOException {
fail();
assertEquals("FRAME_SIZE_ERROR length > 16383: 16384",e.getMessage());
}