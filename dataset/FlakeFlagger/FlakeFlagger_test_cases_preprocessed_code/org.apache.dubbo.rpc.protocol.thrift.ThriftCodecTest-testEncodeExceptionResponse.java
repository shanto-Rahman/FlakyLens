@Test public void testEncodeExceptionResponse() throws Exception {
if (bis.markSupported()) {
}
Assert.assertEquals(ThriftCodec.MAGIC,protocol.readI16());
Assert.assertEquals(protocol.readI32() + 4,bos.writerIndex());
Assert.assertEquals(ThriftCodec.VERSION,protocol.readByte());
Assert.assertEquals(Demo.Iface.class.getName(),protocol.readString());
Assert.assertEquals(request.getId(),protocol.readI64());
if (bis.markSupported()) {
}
Assert.assertEquals("echoString",message.name);
Assert.assertEquals(TMessageType.EXCEPTION,message.type);
Assert.assertEquals(ThriftCodec.getSeqId(),message.seqid);
Assert.assertEquals(exceptionMessage,exception.getMessage());
}