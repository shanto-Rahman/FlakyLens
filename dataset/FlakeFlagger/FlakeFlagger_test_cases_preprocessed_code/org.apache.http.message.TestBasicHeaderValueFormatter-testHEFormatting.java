@Test public void testHEFormatting() throws Exception {
Assert.assertEquals("name=value; param=regular_stuff; param=\"this\\\\that\"; param=\"this,that\"; param",BasicHeaderValueFormatter.formatHeaderElement(element,false,null));
}