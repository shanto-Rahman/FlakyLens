/** 
 * 根据查询条件进行查询
 */
@Test public void testDynamicSelect(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Country country=new Country();
    country.setCountrycode("CN");
    Assert.assertEquals(1,mapper.selectCount(country));
  }
  finally {
    sqlSession.close();
  }
}
