/** 
 * 查询全部
 */
@Test public void testAllColumns(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Country country=new Country();
    country.setCountrycode("CN");
    country.setId(35);
    country.setCountryname("China");
    List<Country> countryList=mapper.select(country);
    Assert.assertEquals(1,countryList.size());
  }
  finally {
    sqlSession.close();
  }
}
