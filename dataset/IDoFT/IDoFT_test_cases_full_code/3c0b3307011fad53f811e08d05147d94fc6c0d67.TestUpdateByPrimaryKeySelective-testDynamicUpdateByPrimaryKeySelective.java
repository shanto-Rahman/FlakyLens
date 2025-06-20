/** 
 * 根据查询条件进行查询
 */
@Test public void testDynamicUpdateByPrimaryKeySelective(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Country country=new Country();
    country.setId(173);
    country.setCountryname("英国");
    Assert.assertEquals(1,mapper.updateByPrimaryKeySelective(country));
    country=mapper.selectByPrimaryKey(173);
    Assert.assertNotNull(country);
    Assert.assertEquals(173,(int)country.getId());
    Assert.assertEquals("英国",country.getCountryname());
    Assert.assertNotNull(country.getCountrycode());
    Assert.assertEquals("GB",country.getCountrycode());
  }
  finally {
    sqlSession.close();
  }
}
