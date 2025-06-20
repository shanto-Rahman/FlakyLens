@Test public void testParseUrls(){
assertEquals("192.168.0.1" + ":10000",urls.get(0).getAddress());
assertEquals("192.168.0.2" + ":10000",urls.get(1).getAddress());
}