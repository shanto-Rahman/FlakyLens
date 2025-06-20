@Test @InSequence(1) public void testWSDL() throws Exception {
assertNotNull(wsdl);
assertThat(wsdl,containsString("wsdl:definitions"));
}