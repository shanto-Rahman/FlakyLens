/** 
 * 根据查询条件进行查询
 */
@Test public void testDynamicSelect(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Country country=new Country();
    country.setCountrycode("CN");
    Country result=mapper.selectOne(country);
    Assert.assertEquals(true,result.getId() == 35);
    Assert.assertEquals("China",result.getCountryname());
  }
  finally {
    sqlSession.close();
  }
}
