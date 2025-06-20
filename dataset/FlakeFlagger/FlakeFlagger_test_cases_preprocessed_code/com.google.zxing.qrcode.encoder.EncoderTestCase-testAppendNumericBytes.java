@Test public void testAppendNumericBytes(){
assertEquals(" ...X",bits.toString());
assertEquals(" ...XX..",bits.toString());
assertEquals(" ...XXXX. XX",bits.toString());
assertEquals(" ...XXXX. XX.X..",bits.toString());
assertEquals("",bits.toString());
}