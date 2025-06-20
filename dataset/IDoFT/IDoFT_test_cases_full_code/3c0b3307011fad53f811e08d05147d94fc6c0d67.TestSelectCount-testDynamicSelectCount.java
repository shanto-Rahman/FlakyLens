/** 
 * 查询全部
 */
@Test public void testDynamicSelectCount(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Assert.assertEquals(183,mapper.selectCount(new Country()));
  }
  finally {
    sqlSession.close();
  }
}
