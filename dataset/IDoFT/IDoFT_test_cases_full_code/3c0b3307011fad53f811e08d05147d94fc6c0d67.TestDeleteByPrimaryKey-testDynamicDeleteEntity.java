/** 
 * 对象包含主键即可
 */
@Test public void testDynamicDeleteEntity(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Country country=new Country();
    country.setId(100);
    Assert.assertEquals(1,mapper.deleteByPrimaryKey(country));
  }
  finally {
    sqlSession.close();
  }
}
