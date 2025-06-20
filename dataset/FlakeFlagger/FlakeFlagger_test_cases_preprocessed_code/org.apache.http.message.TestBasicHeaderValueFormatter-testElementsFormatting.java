@Test public void testElementsFormatting() throws Exception {
Assert.assertEquals("name1=value1; param=regular_stuff, name2=value2; " + "param=\"this\\\\that\", name3=value3; param=\"this,that\", " + "name4=value4; param, name5",BasicHeaderValueFormatter.formatElements(elements,false,null));
}