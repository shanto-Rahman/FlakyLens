@Test public void parseEventParkingFaciltyStatus() throws AdapterException {
  String jo=getDatex2ParkingFacilityStatus();
  XmlParser parserStatus=new XmlParser("parkingAreaStatus");
  XmlParser parserFacility=new XmlParser("parkingFacilityStatus");
  List<byte[]> parsedEvent=parserStatus.parseNEvents(getInputStream(jo),1);
  assertEquals(parsedEvent.size(),2);
  String parsedStringEvent=new String(parsedEvent.get(0),StandardCharsets.UTF_8);
  assertEquals(321,parsedStringEvent.length());
  parsedEvent=parserFacility.parseNEvents(getInputStream(jo),1);
  assertEquals(parsedEvent.size(),10);
  parsedStringEvent=new String(parsedEvent.get(0),StandardCharsets.UTF_8);
  assertEquals(383,parsedStringEvent.length());
}
