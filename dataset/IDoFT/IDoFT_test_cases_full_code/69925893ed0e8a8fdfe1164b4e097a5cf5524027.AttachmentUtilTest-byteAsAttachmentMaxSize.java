@Test public void byteAsAttachmentMaxSize() throws IOException {
  CachedOutputStream cos=createMock(CachedOutputStream.class);
  cos=testSetStreamedAttachmentProperties(AttachmentDeserializer.ATTACHMENT_MAX_SIZE,Byte.MAX_VALUE,cos);
  replay(cos);
  cos.setMaxSize(Byte.MAX_VALUE);
  cos.setThreshold(102400L);
  verify(cos);
}
