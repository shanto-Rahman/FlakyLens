@Test public void badWindowSizeIncrement() throws IOException {
fail();
assertEquals("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: 0",e.getMessage());
fail();
assertEquals("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: 2147483648",e.getMessage());
}