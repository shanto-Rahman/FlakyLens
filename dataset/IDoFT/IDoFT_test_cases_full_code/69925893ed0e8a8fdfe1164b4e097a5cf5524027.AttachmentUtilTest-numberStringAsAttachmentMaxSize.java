@Test public void numberStringAsAttachmentMaxSize() throws IOException {
  CachedOutputStream cos=createMock(CachedOutputStream.class);
  cos=testSetStreamedAttachmentProperties(AttachmentDeserializer.ATTACHMENT_MAX_SIZE,"12345",cos);
  replay(cos);
  cos.setMaxSize(12345);
  cos.setThreshold(102400L);
  verify(cos);
}
