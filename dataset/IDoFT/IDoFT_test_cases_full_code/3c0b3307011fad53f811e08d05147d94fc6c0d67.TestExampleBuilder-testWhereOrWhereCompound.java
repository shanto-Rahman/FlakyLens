@Test public void testWhereOrWhereCompound(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Example example=Example.builder(Country.class).where(Sqls.custom().andEqualTo("countryname","China").andEqualTo("id",35)).orWhere(Sqls.custom().andEqualTo("id",183)).build();
    List<Country> countries=mapper.selectByExample(example);
    Assert.assertEquals(2,countries.size());
  }
  finally {
    sqlSession.close();
  }
}
