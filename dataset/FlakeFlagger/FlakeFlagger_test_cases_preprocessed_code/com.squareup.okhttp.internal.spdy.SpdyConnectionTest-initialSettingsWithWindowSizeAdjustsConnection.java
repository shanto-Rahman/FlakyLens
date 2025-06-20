@Test public void initialSettingsWithWindowSizeAdjustsConnection() throws Exception {
assertEquals(0,connection.bytesLeftInWriteWindow);
assertEquals(0,connection.getStream(1).bytesLeftInWriteWindow);
assertEquals(1,connection.bytesLeftInWriteWindow);
assertEquals(1,connection.getStream(1).bytesLeftInWriteWindow);
assertEquals(0,connection.bytesLeftInWriteWindow);
assertEquals(0,connection.getStream(1).bytesLeftInWriteWindow);
assertEquals(0,connection.bytesLeftInWriteWindow);
assertEquals(1,connection.getStream(1).bytesLeftInWriteWindow);
}