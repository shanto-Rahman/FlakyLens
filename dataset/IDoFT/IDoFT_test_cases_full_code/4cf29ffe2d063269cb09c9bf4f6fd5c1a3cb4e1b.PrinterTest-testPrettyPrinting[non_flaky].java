@Test public void testPrettyPrinting(){
  Map<Integer,String> m=new LinkedHashMap();
  m.put(3,"Three");
  m.put(4,"Four");
  List<?> list=Arrays.asList(new LinkedHashSet(Arrays.asList(1,2)),m);
  String s=Printers.printString(Printers.prettyPrinterProtocol(),list);
  assertEquals("[\n  #{\n    1\n    2\n  }\n  {\n    3 \"Three\"\n    4 \"Four\"\n  }\n]",s);
}
