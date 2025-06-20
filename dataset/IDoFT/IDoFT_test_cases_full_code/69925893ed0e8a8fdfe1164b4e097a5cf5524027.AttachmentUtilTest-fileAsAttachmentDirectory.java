@Test public void fileAsAttachmentDirectory() throws IOException {
  File attachmentDirectory=new File("/dev/null");
  CachedOutputStream cos=createMock(CachedOutputStream.class);
  cos=testSetStreamedAttachmentProperties(AttachmentDeserializer.ATTACHMENT_DIRECTORY,attachmentDirectory,cos);
  replay(cos);
  cos.setOutputDir(attachmentDirectory);
  cos.setThreshold(102400L);
  verify(cos);
}
