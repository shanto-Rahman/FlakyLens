@Test public void parseEventCarPark() throws AdapterException {
  String jo=getCarParkExample();
  XmlParser parser=new XmlParser("parkhaus");
  List<byte[]> parsedEvent=parser.parseNEvents(getInputStream(jo),1);
  assertEquals(6,parsedEvent.size());
  String parsedStringEvent=new String(parsedEvent.get(0),StandardCharsets.UTF_8);
  assertEquals(117,parsedStringEvent.length());
}
