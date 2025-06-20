@Test public void stringArray(){
  final WithArrays wa=new WithArrays();
  wa.stringArray=new String[]{"a","A"};
  final String exp=getClassPrefix(wa) + "[" + BR+ "  boolArray=<null>,"+ BR+ "  charArray=<null>,"+ BR+ "  intArray=<null>,"+ BR+ "  doubleArray=<null>,"+ BR+ "  longArray=<null>,"+ BR+ "  stringArray={"+ BR+ "    a,"+ BR+ "    A"+ BR+ "  }"+ BR+ "]";
  assertEquals(exp,toString(wa));
}
