/** 
 * 主键格式错误
 */
@Test public void testDynamicDeleteException(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Assert.assertEquals(1,mapper.deleteByPrimaryKey(100));
  }
  finally {
    sqlSession.rollback();
    sqlSession.close();
  }
}
