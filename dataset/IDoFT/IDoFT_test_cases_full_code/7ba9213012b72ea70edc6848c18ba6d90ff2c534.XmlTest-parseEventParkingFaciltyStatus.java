@Test public void parseEventParkingFaciltyStatus() throws AdapterException {
  String jo=getDatex2ParkingFacilityStatus();
  XmlParser parserStatus=new XmlParser("parkingAreaStatus");
  XmlParser parserFacility=new XmlParser("parkingFacilityStatus");
  List<byte[]> parsedEvent=parserStatus.parseNEvents(getInputStream(jo),1);
  assertEquals(parsedEvent.size(),2);
  String parsedStringEvent=new String(parsedEvent.get(0),StandardCharsets.UTF_8);
  assertEquals("{\"parkingAreaReference\":{\"targetClass\":\"ParkingArea\",\"id\":" + "\"1001[Stadtmitte]\",\"version\":1.0},\"totalParkingCapacityLongTermOverride\":3376," + "\"parkingAreaTotalNumberOfVacantParkingSpaces\":1268,\"totalParkingCapacityShortTermOverride\":3376,"+ "\"parkingAreaOccupancy\":0.6244076,"+ "\"parkingAreaStatusTime\":\"2018-07-25T13:17:00.087+02:00\"}",parsedStringEvent);
  parsedEvent=parserFacility.parseNEvents(getInputStream(jo),1);
  assertEquals(parsedEvent.size(),10);
  parsedStringEvent=new String(parsedEvent.get(0),StandardCharsets.UTF_8);
  assertEquals("{\"parkingFacilityReference\":{\"targetClass\":\"ParkingFacility\",\"id\"" + ":\"7[City Point]\",\"version\":1.0},\"parkingFacilityStatus\":\"open\"," + "\"totalNumberOfOccupiedParkingSpaces\":123,\"totalNumberOfVacantParkingSpaces\":97,"+ "\"totalParkingCapacityShortTermOverride\":220,\"totalParkingCapacityOverride\":220,"+ "\"parkingFacilityStatusTime\":\"2018-07-25T13:17:00.087+02:00\","+ "\"parkingFacilityOccupancy\":0.5590909}",parsedStringEvent);
}
