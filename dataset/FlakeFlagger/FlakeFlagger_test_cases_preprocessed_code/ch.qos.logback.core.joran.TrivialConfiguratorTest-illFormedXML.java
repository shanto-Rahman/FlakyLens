@Test public void illFormedXML(){
assertEquals(1,tsl.list.size());
assertTrue(s0.getMessage().startsWith(CoreConstants.XML_PARSING));
}