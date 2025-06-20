@Test public void bigIntAsAttachmentMaxSize() throws IOException {
  CachedOutputStream cos=createMock(CachedOutputStream.class);
  BigInteger bigInteger=new BigInteger(String.valueOf(Long.MAX_VALUE));
  cos=testSetStreamedAttachmentProperties(AttachmentDeserializer.ATTACHMENT_MAX_SIZE,bigInteger,cos);
  replay(cos);
  cos.setMaxSize(bigInteger.longValue());
  cos.setThreshold(102400L);
  verify(cos);
  bigInteger=bigInteger.add(BigInteger.ONE);
  cos=createMock(CachedOutputStream.class);
  cos=testSetStreamedAttachmentProperties(AttachmentDeserializer.ATTACHMENT_MAX_SIZE,bigInteger,cos);
  replay(cos);
  cos.setThreshold(102400L);
  verify(cos);
}
