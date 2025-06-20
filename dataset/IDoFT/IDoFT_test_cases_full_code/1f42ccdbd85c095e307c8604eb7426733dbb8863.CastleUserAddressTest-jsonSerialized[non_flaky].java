@Test public void jsonSerialized(){
  CastleUserAddress address=new CastleUserAddress();
  address.setCity("city");
  address.setCountry("country");
  address.setPostalCode("12345");
  address.setRegion("region");
  address.setStreet("street 1");
  String payloadJson=model.getGson().toJson(address);
  JsonParser parser=new JsonParser();
  String expected="{\"street\":\"street 1\",\"city\":\"city\",\"postal_code\":\"12345\",\"region\":\"region\",\"country\":\"country\"}";
  Assertions.assertThat(parser.parse(payloadJson)).isEqualTo(parser.parse(expected));
}
