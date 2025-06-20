@Test public void gunzipWhenCRCIncorrect() throws Exception {
fail();
assertEquals("CRC: actual 0x37ad8f8d != expected 0x01234567",e.getMessage());
}