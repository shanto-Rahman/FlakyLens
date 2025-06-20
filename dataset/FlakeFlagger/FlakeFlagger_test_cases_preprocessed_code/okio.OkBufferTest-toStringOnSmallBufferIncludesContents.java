@Test public void toStringOnSmallBufferIncludesContents() throws Exception {
assertEquals("OkBuffer[size=16 data=a1b2c3d4e5f61a2b3c4d5e6f10203040]",buffer.toString());
}