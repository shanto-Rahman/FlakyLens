/** 
 * 插入完整数据
 */
@Test public void testDynamicInsert(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Country country=new Country();
    country.setId(10086);
    country.setCountrycode("CN");
    country.setCountryname("天朝");
    Assert.assertEquals(1,mapper.insert(country));
    country=new Country();
    country.setCountrycode("CN");
    List<Country> list=mapper.select(country);
    Assert.assertEquals(2,list.size());
    Assert.assertEquals(1,mapper.deleteByPrimaryKey(10086));
  }
  finally {
    sqlSession.close();
  }
}
