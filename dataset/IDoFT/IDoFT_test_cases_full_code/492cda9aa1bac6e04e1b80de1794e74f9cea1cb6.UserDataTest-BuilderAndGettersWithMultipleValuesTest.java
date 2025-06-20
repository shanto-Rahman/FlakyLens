@Test public void BuilderAndGettersWithMultipleValuesTest(){
  List<String> emails=Arrays.asList("email0","email1");
  List<String> phones=Arrays.asList("1234567890","2062062006");
  List<GenderEnum> genders=Arrays.asList(GenderEnum.MALE,GenderEnum.FEMALE);
  List<String> datesOfBirth=Arrays.asList("20000101","20000102");
  List<String> lastNames=Arrays.asList("lastname-1","lastname-2");
  List<String> firstNames=Arrays.asList("firstname-2","firstname-3");
  List<String> cities=Arrays.asList("Seattle","Portland");
  List<String> states=Arrays.asList("WA","CA");
  List<String> zipcodes=Arrays.asList("98123","98122");
  List<String> countryCodes=Arrays.asList("USA","CA");
  List<String> externalIds=Arrays.asList("external-1","external-2","external-2");
  UserData userData=new UserData();
  userData.emails(emails).phones(phones).genders(genders).datesOfBirth(datesOfBirth).lastNames(lastNames).firstNames(firstNames).cities(cities).states(states).zipcodes(zipcodes).countryCodes(countryCodes).externalIds(externalIds);
  assertEquals(userData.getEmails(),emails);
  assertEquals(userData.getPhones(),phones);
  assertEquals(userData.getGenders(),genders);
  assertEquals(userData.getDatesOfBirth(),datesOfBirth);
  assertEquals(userData.getLastNames(),lastNames);
  assertEquals(userData.getFirstNames(),firstNames);
  assertEquals(userData.getCities(),cities);
  assertEquals(userData.getStates(),states);
  assertEquals(userData.getZipcodes(),zipcodes);
  assertEquals(userData.getCountryCodes(),countryCodes);
  assertEquals(userData.getExternalIds(),externalIds.subList(0,2));
}
