/** 
 * 入参为null时查询全部
 */
@Test(expected=TooManyResultsException.class) public void testDynamicSelectAllByNull(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    mapper.selectOne(null);
  }
  finally {
    sqlSession.close();
  }
}
