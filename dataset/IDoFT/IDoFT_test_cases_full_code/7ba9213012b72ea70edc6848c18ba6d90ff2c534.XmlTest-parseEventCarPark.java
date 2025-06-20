@Test public void parseEventCarPark() throws AdapterException {
  String jo=getCarParkExample();
  XmlParser parser=new XmlParser("parkhaus");
  List<byte[]> parsedEvent=parser.parseNEvents(getInputStream(jo),1);
  assertEquals(6,parsedEvent.size());
  String parsedStringEvent=new String(parsedEvent.get(0),StandardCharsets.UTF_8);
  assertEquals("{\"frei\":0,\"tendenz\":3,\"bezeichnung\":\"bahnhof.txt\",\"zeitstempel\":\"25.07.2018 10:45\",\"gesamt\":114,\"lfdnr\":1,\"status\":1}",parsedStringEvent);
}
