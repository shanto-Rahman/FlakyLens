@Test public void testDeleteByIds(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    int count=mapper.deleteByIds("1,2,3");
    Assert.assertEquals(3,count);
    Assert.assertEquals(180,mapper.selectCount(null));
  }
  finally {
    sqlSession.rollback();
    sqlSession.close();
  }
}
