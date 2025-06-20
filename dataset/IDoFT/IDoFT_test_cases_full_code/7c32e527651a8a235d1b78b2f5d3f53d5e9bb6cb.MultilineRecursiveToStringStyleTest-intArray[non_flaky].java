@Test public void intArray(){
  final WithArrays wa=new WithArrays();
  wa.intArray=new int[]{1,2};
  final String exp=getClassPrefix(wa) + "[" + BR+ "  boolArray=<null>,"+ BR+ "  charArray=<null>,"+ BR+ "  doubleArray=<null>,"+ BR+ "  intArray={"+ BR+ "    1,"+ BR+ "    2"+ BR+ "  },"+ BR+ "  longArray=<null>,"+ BR+ "  stringArray=<null>"+ BR+ "]";
  assertEquals(exp,toString(wa));
}
