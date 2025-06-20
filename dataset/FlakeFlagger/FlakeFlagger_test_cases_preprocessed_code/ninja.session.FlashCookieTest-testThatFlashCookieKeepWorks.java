@Test public void testThatFlashCookieKeepWorks(){
assertEquals("flashScope",flashCookie.get("hello"));
assertEquals(1,((FlashCookieImpl)flashCookie).getCurrentFlashCookieData().size());
assertEquals(0,((FlashCookieImpl)flashCookie).getOutgoingFlashCookieData().size());
assertEquals(1,((FlashCookieImpl)flashCookie).getCurrentFlashCookieData().size());
assertEquals(1,((FlashCookieImpl)flashCookie).getOutgoingFlashCookieData().size());
}