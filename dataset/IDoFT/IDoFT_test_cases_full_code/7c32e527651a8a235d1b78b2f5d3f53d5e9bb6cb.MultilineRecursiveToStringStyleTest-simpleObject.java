@Test public void simpleObject(){
  final Transaction tx=new Transaction("2014.10.15",100);
  final String expected=getClassPrefix(tx) + "[" + BR+ "  amount=100.0,"+ BR+ "  date=2014.10.15"+ BR+ "]";
  assertEquals(expected,toString(tx));
}
