@Test public void findByNameAndCountry(){
assertThat(city,notNullValue());
assertThat(city.getName(),is(equalTo("Melbourne")));
}