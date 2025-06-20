@Test public void testEncodeRequest() throws Exception {
if (bis.markSupported()) {
}
Assert.assertEquals(ThriftCodec.MAGIC,protocol.readI16());
Assert.assertEquals(messageLength + 4,bytes.length);
Assert.assertEquals(ThriftCodec.VERSION,protocol.readByte());
Assert.assertEquals(Demo.Iface.class.getName(),protocol.readString());
Assert.assertEquals(request.getId(),protocol.readI64());
if (bis.markSupported()) {
}
Assert.assertEquals("echoString",message.name);
Assert.assertEquals(TMessageType.CALL,message.type);
Assert.assertEquals("Hello, World!",args.getArg());
}