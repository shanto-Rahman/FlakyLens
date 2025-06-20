@Test public void writeAwaitsWindowUpdate() throws Exception {
assertEquals(0,connection.bytesLeftInWriteWindow);
assertEquals(0,connection.getStream(1).bytesLeftInWriteWindow);
assertEquals(TYPE_HEADERS,synStream.type);
assertEquals(TYPE_DATA,data.type);
}