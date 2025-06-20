/** 
 * 查询全部
 */
@Test public void testDynamicSelectAll(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Country country=new Country();
    List<Country> countryList;
    country.setDynamicTableName123(null);
    countryList=mapper.select(country);
    Assert.assertEquals(183,countryList.size());
  }
  finally {
    sqlSession.close();
  }
}
