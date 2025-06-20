@Test public void testFlashCookieSettingWorks(){
assertEquals("NINJA_FLASH",cookieCaptor.getValue().getName());
assertEquals("hello=flashScope",cookieCaptor.getValue().getValue());
assertEquals(-1,cookieCaptor.getValue().getMaxAge());
assertEquals(1,((FlashCookieImpl)flashCookie).getCurrentFlashCookieData().size());
assertEquals(1,((FlashCookieImpl)flashCookie).getOutgoingFlashCookieData().size());
}