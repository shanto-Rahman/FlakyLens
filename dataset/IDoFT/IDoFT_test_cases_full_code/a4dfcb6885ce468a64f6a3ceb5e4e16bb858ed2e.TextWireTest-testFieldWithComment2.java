@Test public void testFieldWithComment2(){
  FieldWithComment2 f=new FieldWithComment2();
  f.field="hello world";
  Assert.assertEquals("!net.openhft.chronicle.wire.TextWireTest$FieldWithComment2 {\n" + "  field: hello world, \t\t# a comment where the value=hello world\n" + "  field2: !!null \"\"\n"+ "}\n",Marshallable.$toString(f));
}
