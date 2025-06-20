/** 
 * 入参为null时查询全部
 */
@Test public void testDynamicSelectAllByNull(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Assert.assertEquals(183,mapper.selectCount(null));
  }
  finally {
    sqlSession.close();
  }
}
