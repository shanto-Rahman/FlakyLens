@Test public void longArray(){
  final WithArrays wa=new WithArrays();
  wa.longArray=new long[]{1L,2L};
  final String exp=getClassPrefix(wa) + "[" + BR+ "  boolArray=<null>,"+ BR+ "  charArray=<null>,"+ BR+ "  doubleArray=<null>,"+ BR+ "  intArray=<null>,"+ BR+ "  longArray={"+ BR+ "    1,"+ BR+ "    2"+ BR+ "  },"+ BR+ "  stringArray=<null>"+ BR+ "]";
  assertEquals(exp,toString(wa));
}
