@Test public void testThatFlashCookieWorksAndIsActiveOnlyOneTime(){
assertEquals("flashScope",flashCookie.get("hello"));
assertEquals("NINJA_FLASH",cookieCaptor.getValue().getName());
assertEquals("another+message=is+there...&yet+another+message=is+there...",cookieCaptor.getValue().getValue());
assertEquals(3,((FlashCookieImpl)flashCookie).getCurrentFlashCookieData().size());
assertEquals(2,((FlashCookieImpl)flashCookie).getOutgoingFlashCookieData().size());
}