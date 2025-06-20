/** 
 * 根据PK进行查询
 */
@Test public void testDynamicSelectByPrimaryKey2(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Country country=mapper.selectByPrimaryKey(35);
    Assert.assertNotNull(country);
    Assert.assertEquals(true,country.getId() == 35);
    Assert.assertEquals("China",country.getCountryname());
    Assert.assertEquals("CN",country.getCountrycode());
  }
  finally {
    sqlSession.close();
  }
}
