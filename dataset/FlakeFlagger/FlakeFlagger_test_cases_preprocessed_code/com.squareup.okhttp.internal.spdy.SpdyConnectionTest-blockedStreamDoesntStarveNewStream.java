@Test public void blockedStreamDoesntStarveNewStream() throws Exception {
assertEquals(0,connection.bytesLeftInWriteWindow);
assertEquals(0,connection.getStream(1).bytesLeftInWriteWindow);
assertEquals(3,connection.bytesLeftInWriteWindow);
assertEquals(0,connection.getStream(1).bytesLeftInWriteWindow);
assertEquals(0,connection.bytesLeftInWriteWindow);
assertEquals(0,connection.getStream(1).bytesLeftInWriteWindow);
assertEquals(INITIAL_WINDOW_SIZE - 3,connection.getStream(3).bytesLeftInWriteWindow);
}