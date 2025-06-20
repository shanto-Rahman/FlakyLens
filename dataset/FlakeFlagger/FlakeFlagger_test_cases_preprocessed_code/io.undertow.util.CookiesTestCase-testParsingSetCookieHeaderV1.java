@Test public void testParsingSetCookieHeaderV1(){
Assert.assertEquals("Customer",cookie.getName());
Assert.assertEquals("WILE_E_COYOTE",cookie.getValue());
Assert.assertEquals("/acme",cookie.getPath());
Assert.assertEquals(1,cookie.getVersion());
Assert.assertEquals("SHIPPING",cookie.getName());
Assert.assertEquals("FEDEX",cookie.getValue());
Assert.assertEquals("/foo",cookie.getPath());
Assert.assertTrue(cookie.isSecure());
Assert.assertEquals(1,cookie.getVersion());
}