@Test public void shortAsAttachmentMaxSize() throws IOException {
  CachedOutputStream cos=createMock(CachedOutputStream.class);
  cos=testSetStreamedAttachmentProperties(AttachmentDeserializer.ATTACHMENT_MAX_SIZE,Short.MAX_VALUE,cos);
  replay(cos);
  cos.setMaxSize(Short.MAX_VALUE);
  cos.setThreshold(102400L);
  verify(cos);
}
