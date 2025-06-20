@Test public void charArray(){
  final WithArrays wa=new WithArrays();
  wa.charArray=new char[]{'a','A'};
  final String exp=getClassPrefix(wa) + "[" + BR+ "  boolArray=<null>,"+ BR+ "  charArray={"+ BR+ "    a,"+ BR+ "    A"+ BR+ "  },"+ BR+ "  intArray=<null>,"+ BR+ "  doubleArray=<null>,"+ BR+ "  longArray=<null>,"+ BR+ "  stringArray=<null>"+ BR+ "]";
  assertEquals(exp,toString(wa));
}
