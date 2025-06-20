/** 
 * Map可以随意
 */
@Test public void testSelectByPrimaryKeyMap(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Map map=new HashMap();
    map.put("id",35);
    Country country=mapper.selectByPrimaryKey(map);
    Assert.assertNotNull(country);
    Assert.assertEquals(true,country.getId() == 35);
    Assert.assertEquals("China",country.getCountryname());
    Assert.assertEquals("CN",country.getCountrycode());
    map=new HashMap();
    map.put("countryname","China");
    Assert.assertNull(mapper.selectByPrimaryKey(map));
  }
  finally {
    sqlSession.close();
  }
}
