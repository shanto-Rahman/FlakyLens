/** 
 * 查询全部
 */
@Test(expected=TooManyResultsException.class) public void testDynamicSelectAll(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Country country=mapper.selectOne(new Country());
  }
  finally {
    sqlSession.close();
  }
}
