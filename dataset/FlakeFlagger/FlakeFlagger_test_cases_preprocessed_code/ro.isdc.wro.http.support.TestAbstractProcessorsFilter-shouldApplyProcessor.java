@Test public void shouldApplyProcessor() throws Exception {
Assert.assertEquals(processedMessage,new String(outputStream.toByteArray()));
}