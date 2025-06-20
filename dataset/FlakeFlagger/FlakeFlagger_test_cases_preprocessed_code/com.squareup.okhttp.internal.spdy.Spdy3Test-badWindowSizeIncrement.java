@Test public void badWindowSizeIncrement() throws IOException {
fail();
assertEquals("windowSizeIncrement must be between 1 and 0x7fffffff: 0",e.getMessage());
fail();
assertEquals("windowSizeIncrement must be between 1 and 0x7fffffff: 2147483648",e.getMessage());
}