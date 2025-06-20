@Test public void integerAsAttachmentMaxSize() throws IOException {
  CachedOutputStream cos=createMock(CachedOutputStream.class);
  cos=testSetStreamedAttachmentProperties(AttachmentDeserializer.ATTACHMENT_MAX_SIZE,Integer.MAX_VALUE,cos);
  replay(cos);
  cos.setMaxSize(Integer.MAX_VALUE);
  cos.setThreshold(102400L);
  verify(cos);
}
