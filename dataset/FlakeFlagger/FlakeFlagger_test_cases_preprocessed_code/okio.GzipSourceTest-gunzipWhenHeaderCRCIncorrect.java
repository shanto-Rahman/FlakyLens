/** 
 * Note that you cannot test this with old versions of gzip, as they interpret flag bit 1 as CONTINUATION, not HCRC. For example, this is the case with the default gzip on osx.
 */
@Test public void gunzipWhenHeaderCRCIncorrect() throws Exception {
fail();
assertEquals("FHCRC: actual 0x0000261d != expected 0x00000000",e.getMessage());
}