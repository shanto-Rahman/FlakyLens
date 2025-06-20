@Test public void testEncodeReplyResponse() throws Exception {
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
Assert.assertEquals(TMessageType.REPLY,message.type);
Assert.assertEquals(rpcResult.getValue(),result.getSuccess());
}