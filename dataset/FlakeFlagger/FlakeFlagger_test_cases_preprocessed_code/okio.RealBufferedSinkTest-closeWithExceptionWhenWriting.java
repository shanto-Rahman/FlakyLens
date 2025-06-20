@Test public void closeWithExceptionWhenWriting() throws IOException {
mockSink.scheduleThrow(0,new IOException());//IT
fail();
mockSink.assertLog("write(OkBuffer[size=1 data=61], 1)","close()");//IT
}