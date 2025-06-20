@Test public void testCustomizeTomcatHeaderSize() throws Exception {
assertEquals(9999,this.properties.getTomcat().getMaxHttpHeaderSize());
}