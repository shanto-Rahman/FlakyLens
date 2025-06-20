@Test public void outWriterStreamTest() throws Exception {
  CachedWriter cWriter=new CachedWriter();
  message.setContent(Writer.class,cWriter);
  outInterceptor.handleMessage(message);
  Writer tWriter=message.getContent(Writer.class);
  IOUtils.copy(new InputStreamReader(messageIS),tWriter,IOUtils.DEFAULT_BUFFER_SIZE);
  tWriter.close();
  Document doc=StaxUtils.read(cWriter.getReader());
  Assert.assertTrue("Message was not transformed",checkTransformedXML(doc));
}
