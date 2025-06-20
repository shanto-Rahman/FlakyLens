@Test public void testAppendBytes() throws WriterException {
assertEquals(" ...X",bits.toString());
assertEquals(" ..X.X.",bits.toString());
assertEquals(" .XX....X .XX...X. .XX...XX",bits.toString());
assertEquals(" .XX.XX.. XXXXX",bits.toString());
}