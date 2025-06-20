@Test public void BuilderAndGettersWithMultipleValuesTest(){
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
assertEquals(sortedActualExternalIds,externalIds.subList(0,2));
}