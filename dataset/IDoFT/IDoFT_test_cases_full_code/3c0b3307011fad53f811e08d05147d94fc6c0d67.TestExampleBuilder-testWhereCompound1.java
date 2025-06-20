@Test public void testWhereCompound1(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Example example=Example.builder(Country.class).where(Sqls.custom().andBetween("id",35,50).orLessThan("id",40).orIsNull("countryname")).build();
    List<Country> countries=mapper.selectByExample(example);
    Assert.assertEquals(50,countries.size());
  }
  finally {
    sqlSession.close();
  }
}
