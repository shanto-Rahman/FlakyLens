@Test public void longAsAttachmentMaxSize() throws IOException {
  CachedOutputStream cos=createMock(CachedOutputStream.class);
  cos=testSetStreamedAttachmentProperties(AttachmentDeserializer.ATTACHMENT_MAX_SIZE,Long.MAX_VALUE,cos);
  replay(cos);
  cos.setMaxSize(Long.MAX_VALUE);
  cos.setThreshold(102400L);
  verify(cos);
}
