@Test public void testFieldWithComment2(){
Assert.assertEquals("!net.openhft.chronicle.wire.YamlWireTest$FieldWithComment2 {\n" + "  field: hello world, \t\t# a comment where the value=hello world\n" + "  field2: !!null \"\"\n"+ "}\n",Marshallable.$toString(f));
}