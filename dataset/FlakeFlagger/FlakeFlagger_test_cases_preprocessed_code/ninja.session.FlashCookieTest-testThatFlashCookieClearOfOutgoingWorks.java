@Test public void testThatFlashCookieClearOfOutgoingWorks(){
assertEquals("flashScope",flashCookie.get("hello"));
assertEquals(2,((FlashCookieImpl)flashCookie).getCurrentFlashCookieData().size());
assertEquals(0,((FlashCookieImpl)flashCookie).getOutgoingFlashCookieData().size());
}