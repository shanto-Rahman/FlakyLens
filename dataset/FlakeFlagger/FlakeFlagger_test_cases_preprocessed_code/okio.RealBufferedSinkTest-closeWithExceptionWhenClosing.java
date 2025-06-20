@Test public void closeWithExceptionWhenClosing() throws IOException {
mockSink.scheduleThrow(1,new IOException());//IT
fail();
mockSink.assertLog("write(OkBuffer[size=1 data=61], 1)","close()");//IT
}