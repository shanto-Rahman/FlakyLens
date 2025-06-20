@Test public void testThatFlashCookieClearWorks(){
assertEquals("flashScope",flashCookie.get("hello"));
assertEquals(0,((FlashCookieImpl)flashCookie).getCurrentFlashCookieData().size());
assertEquals(1,((FlashCookieImpl)flashCookie).getOutgoingFlashCookieData().size());
}