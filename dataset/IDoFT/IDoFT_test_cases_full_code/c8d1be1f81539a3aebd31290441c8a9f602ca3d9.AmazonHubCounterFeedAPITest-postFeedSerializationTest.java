@Test @DisplayName("Successful Feed JSON serialization") public void postFeedSerializationTest() throws IOException {
  AccessPoint[] accessPoints=new AccessPoint[1];
  Address address=Address.builder().addressFieldOne("1918 8th Ave, Seattle, WA 98101, USA").city("Seattle").postalCode("98101").countryCode("US").latitude("47.615564").longitude("-122.335819").build();
  String[] capabilities={"PICK_UP","DROP_OFF"};
  ExceptionalClosure[] exceptionalClosures=new ExceptionalClosure[1];
  exceptionalClosures[0]=ExceptionalClosure.builder().startDateTime("2038-01-19").endDateTime("2038-01-20").build();
  CommunicationDetails communicationDetails=CommunicationDetails.builder().phoneNumber("00 1 206-922-0880").emailId("store-id@example.com").build();
  StandardHours[] standardHours=new StandardHours[6];
  standardHours[0]=StandardHours.builder().day("MONDAY").openingTime("08:30:00").closingTime("20:00:00").build();
  standardHours[1]=StandardHours.builder().day("TUESDAY").openingTime("08:30:00").closingTime("20:00:00").build();
  standardHours[2]=StandardHours.builder().day("WEDNESDAY").openingTime("08:30:00").closingTime("20:00:00").build();
  standardHours[3]=StandardHours.builder().day("THURSDAY").openingTime("08:30:00").closingTime("20:00:00").build();
  standardHours[4]=StandardHours.builder().day("FRIDAY").openingTime("08:30:00").closingTime("20:00:00").build();
  MidDayClosure[] midDayClosures=new MidDayClosure[1];
  midDayClosures[0]=MidDayClosure.builder().startTime("12:00:00").endTime("13:00:00").build();
  standardHours[5]=StandardHours.builder().day("SATURDAY").openingTime("08:30:00").closingTime("20:00:00").midDayClosures(midDayClosures).build();
  accessPoints[0]=AccessPoint.builder().accessPointId("AMAZON-US-HQ").accessPointName("Amazon Hub Counter - Amazon US HQ").isActive(true).isRestrictedAccess(false).timeZone("America/Los_Angeles").address(address).terminationDate("2199-12-31").capabilities(capabilities).standardHoursList(standardHours).exceptionalClosures(exceptionalClosures).communicationDetails(communicationDetails).build();
  AccessPointsFeedRequest accessPointsFeedRequest=AccessPointsFeedRequest.builder().accessPoints(accessPoints).build();
  String feedRequestJson=new String(Files.readAllBytes(Paths.get("src/test/resources/__files/feeds/feedRequest.json")));
  assertEquals(accessPointsFeedRequest.toJson(),feedRequestJson);
}
