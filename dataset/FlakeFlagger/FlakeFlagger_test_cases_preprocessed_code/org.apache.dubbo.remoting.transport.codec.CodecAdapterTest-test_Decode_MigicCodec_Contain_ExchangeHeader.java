@Test public void test_Decode_MigicCodec_Contain_ExchangeHeader() throws IOException {
Assert.assertEquals(TelnetCodec.DecodeResult.NEED_MORE_INPUT,obj);
Assert.assertEquals(2,buffer.readerIndex());
}