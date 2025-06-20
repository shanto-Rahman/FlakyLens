@Test public void testParsingSetCookieHeaderV0(){
Assert.assertEquals("CUSTOMER",cookie.getName());
Assert.assertEquals("WILE_E_COYOTE",cookie.getValue());
Assert.assertEquals("/",cookie.getPath());
Assert.assertEquals(date(1999,11,9,23,12,40),cookie.getExpires());
Assert.assertEquals("SHIPPING",cookie.getName());
Assert.assertEquals("FEDEX",cookie.getValue());
Assert.assertEquals("/foo",cookie.getPath());
Assert.assertTrue(cookie.isSecure());
}