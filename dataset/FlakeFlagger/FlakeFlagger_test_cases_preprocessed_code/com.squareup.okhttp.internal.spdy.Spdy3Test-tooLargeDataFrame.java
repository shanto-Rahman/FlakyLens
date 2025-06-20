@Test public void tooLargeDataFrame() throws IOException {
fail();
assertEquals("FRAME_TOO_LARGE max size is 16Mib: " + 0x1000000L,e.getMessage());
}