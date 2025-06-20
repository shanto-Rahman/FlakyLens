@Test public void shouldGenerateDateAsStringWithUSLocale(){
assertEquals("Thu, 07 Feb 2013 23:07:39 GMT",WroUtil.toDateAsString(milliseconds));
}