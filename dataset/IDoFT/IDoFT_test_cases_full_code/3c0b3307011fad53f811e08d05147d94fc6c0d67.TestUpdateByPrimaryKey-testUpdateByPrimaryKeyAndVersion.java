/** 
 * 根据查询条件进行查询
 */
@Test public void testUpdateByPrimaryKeyAndVersion(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryVersionMapper mapper=sqlSession.getMapper(CountryVersionMapper.class);
    CountryVersion country=mapper.selectByPrimaryKey(174);
    Assert.assertNotNull(country);
    Assert.assertEquals(new Integer(1),country.getVersion());
    country.setCountryname("美国2");
    Assert.assertEquals(1,mapper.updateByPrimaryKey(country));
    country=mapper.selectByPrimaryKey(174);
    Assert.assertNotNull(country);
    Assert.assertEquals(new Integer(2),country.getVersion());
    country.setCountryname("美国3");
    Assert.assertEquals(1,mapper.updateByPrimaryKey(country));
    country=mapper.selectByPrimaryKey(174);
    Assert.assertNotNull(country);
    Assert.assertEquals(new Integer(3),country.getVersion());
    country.setCountryname("美国4");
    Assert.assertEquals(1,mapper.updateByPrimaryKey(country));
    country=mapper.selectByPrimaryKey(174);
    Assert.assertNotNull(country);
    Assert.assertEquals(new Integer(4),country.getVersion());
  }
  finally {
    sqlSession.close();
  }
}
