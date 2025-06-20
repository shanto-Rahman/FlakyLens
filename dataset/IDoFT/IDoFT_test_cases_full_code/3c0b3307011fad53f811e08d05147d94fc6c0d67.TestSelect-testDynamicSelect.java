/** 
 * 根据查询条件进行查询
 */
@Test public void testDynamicSelect(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Country country=new Country();
    country.setCountrycode("CN");
    List<Country> countryList=mapper.select(country);
    Assert.assertEquals(1,countryList.size());
    Assert.assertEquals(true,countryList.get(0).getId() == 35);
    Assert.assertEquals("China",countryList.get(0).getCountryname());
  }
  finally {
    sqlSession.close();
  }
}
