@Test public void closeWithExceptionWhenWritingAndClosing() throws IOException {
mockSink.scheduleThrow(0,new IOException("first"));//IT
mockSink.scheduleThrow(1,new IOException("second"));//IT
fail();
assertEquals("first",expected.getMessage());
mockSink.assertLog("write(OkBuffer[size=1 data=61], 1)","close()");//IT
}