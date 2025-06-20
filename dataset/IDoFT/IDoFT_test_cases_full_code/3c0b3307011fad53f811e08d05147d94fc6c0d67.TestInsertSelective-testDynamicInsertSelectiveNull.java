/** 
 * Countrycode默认值HH
 */
@Test public void testDynamicInsertSelectiveNull(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Country country=new Country();
    country.setId(10086);
    country.setCountryname("天朝");
    Assert.assertEquals(1,mapper.insertSelective(country));
    country=new Country();
    country.setId(10086);
    List<Country> list=mapper.select(country);
    Assert.assertEquals(1,list.size());
    Assert.assertNotNull(list.get(0).getCountrycode());
    Assert.assertEquals("HH",list.get(0).getCountrycode());
    Assert.assertEquals(1,mapper.deleteByPrimaryKey(10086));
  }
  finally {
    sqlSession.close();
  }
}
