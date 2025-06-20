@Test public void gunzipWhenLengthIncorrect() throws Exception {
fail();
assertEquals("ISIZE: actual 0x00000020 != expected 0x00123456",e.getMessage());
}