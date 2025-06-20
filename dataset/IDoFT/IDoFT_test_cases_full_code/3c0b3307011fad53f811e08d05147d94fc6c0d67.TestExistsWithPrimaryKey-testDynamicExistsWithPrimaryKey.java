/** 
 * 根据PK进行查询
 */
@Test public void testDynamicExistsWithPrimaryKey(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Country country=new Country();
    country.setId(35);
    Assert.assertEquals(true,mapper.existsWithPrimaryKey(country));
    country.setId(0);
    Assert.assertEquals(false,mapper.existsWithPrimaryKey(country));
  }
  finally {
    sqlSession.close();
  }
}
