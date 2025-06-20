@Test public void maxFrameSizeHonored() throws Exception {
assertEquals(TYPE_HEADERS,synStream.type);
assertEquals(HTTP_20_DRAFT_09.maxFrameSize(),data.data.length);
assertEquals(1,data.data.length);
}