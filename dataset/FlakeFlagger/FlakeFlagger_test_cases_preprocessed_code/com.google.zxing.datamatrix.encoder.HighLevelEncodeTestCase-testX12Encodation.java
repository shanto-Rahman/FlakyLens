@Test public void testX12Encodation(){
assertEquals("238 89 233 14 192 100 207 44 31 67",visualized);
assertEquals("238 89 233 14 192 100 207 44 31 254 67 68",visualized);
assertEquals("238 89 233 14 192 100 207 44 31 96 82 254",visualized);
assertEquals("238 89 233 14 192 100 207 44 31 96 82 70",visualized);
assertEquals("238 89 233 14 192 100 207 44 31 96 82 254 70 71 129 237",visualized);
}