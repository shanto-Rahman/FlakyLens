/** 
 * 查询全部
 */
@Test public void testDynamicSelectPage(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Country country=new Country();
    country.setCountrycode("US");
    List<Country> countryList=mapper.selectPage(country,0,10);
    Assert.assertEquals(1,countryList.size());
    countryList=mapper.selectPage(null,100,10);
    Assert.assertEquals(10,countryList.size());
  }
  finally {
    sqlSession.close();
  }
}
