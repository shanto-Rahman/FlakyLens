/** 
 * 包含主键的对象做参数就行
 */
@Test public void testDynamicSelectByPrimaryKey(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Country country=new Country();
    country.setId(35);
    country=mapper.selectByPrimaryKey(country);
    Assert.assertNotNull(country);
    Assert.assertEquals(true,country.getId() == 35);
    Assert.assertEquals("China",country.getCountryname());
    Assert.assertEquals("CN",country.getCountrycode());
  }
  finally {
    sqlSession.close();
  }
}
