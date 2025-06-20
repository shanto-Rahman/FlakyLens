@Test public void testAppendLengthInfo() throws WriterException {
assertEquals(" ........ .X",bits.toString());
assertEquals(" ........ .X.",bits.toString());
assertEquals(" ........ XXXXXXXX",bits.toString());
assertEquals(" ..X..... ....",bits.toString());
}