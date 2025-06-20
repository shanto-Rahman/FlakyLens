@Test public void doubleArray(){
  final WithArrays wa=new WithArrays();
  wa.doubleArray=new double[]{1,2};
  final String exp=getClassPrefix(wa) + "[" + BR+ "  boolArray=<null>,"+ BR+ "  charArray=<null>,"+ BR+ "  doubleArray={"+ BR+ "    1.0,"+ BR+ "    2.0"+ BR+ "  },"+ BR+ "  intArray=<null>,"+ BR+ "  longArray=<null>,"+ BR+ "  stringArray=<null>"+ BR+ "]";
  assertEquals(exp,toString(wa));
}
