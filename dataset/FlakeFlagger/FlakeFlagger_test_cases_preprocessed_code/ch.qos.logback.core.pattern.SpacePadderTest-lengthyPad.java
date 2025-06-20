@Test public void lengthyPad(){
assertEquals("                              abc",buf.toString());
assertEquals("abc                              ",buf.toString());
}