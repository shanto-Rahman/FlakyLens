@Test public void testParseURLWithSpecial(){
assertEquals("dubbo://" + address,UrlUtils.parseURL(address,null).toString());
}