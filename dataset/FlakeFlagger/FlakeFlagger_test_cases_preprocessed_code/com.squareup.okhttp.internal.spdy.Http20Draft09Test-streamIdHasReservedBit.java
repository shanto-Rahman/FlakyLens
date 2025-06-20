@Test public void streamIdHasReservedBit() throws IOException {
fail();
assertEquals("reserved bit set: -2147483645",e.getMessage());
}