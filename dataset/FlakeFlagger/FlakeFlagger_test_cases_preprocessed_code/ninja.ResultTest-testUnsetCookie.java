@Test public void testUnsetCookie(){
assertEquals(1,result.getCookies().size());
assertEquals("Cookie-to-be-unset",result.getCookies().get(0).getName());
assertEquals("",result.getCookies().get(0).getValue());
}