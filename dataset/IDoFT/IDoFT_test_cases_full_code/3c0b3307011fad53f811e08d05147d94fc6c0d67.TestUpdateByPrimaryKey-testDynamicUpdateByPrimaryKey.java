/** 
 * 根据查询条件进行查询
 */
@Test public void testDynamicUpdateByPrimaryKey(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Country country=new Country();
    country.setId(174);
    country.setCountryname(null);
    country.setCountryname("美国");
    Assert.assertEquals(1,mapper.updateByPrimaryKey(country));
    country=mapper.selectByPrimaryKey(174);
    Assert.assertNotNull(country);
    Assert.assertEquals(174,(int)country.getId());
    Assert.assertEquals("美国",country.getCountryname());
    Assert.assertNull(country.getCountrycode());
  }
  finally {
    sqlSession.close();
  }
}
