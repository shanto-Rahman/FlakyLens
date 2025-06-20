@Test public void testAppendAlphanumericBytes() throws WriterException {
assertEquals(" ..X.X.",bits.toString());
assertEquals(" ..XXX..X X.X",bits.toString());
assertEquals(" ..XXX..X X.X..XX. .",bits.toString());
assertEquals("",bits.toString());
}