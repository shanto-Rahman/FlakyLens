@Test public void stringAsAttachmentDirectory() throws IOException {
  String attachmentDirectory="/dev/null";
  CachedOutputStream cos=createMock(CachedOutputStream.class);
  cos=testSetStreamedAttachmentProperties(AttachmentDeserializer.ATTACHMENT_DIRECTORY,attachmentDirectory,cos);
  replay(cos);
  cos.setOutputDir(new File(attachmentDirectory));
  cos.setThreshold(102400L);
  verify(cos);
}
