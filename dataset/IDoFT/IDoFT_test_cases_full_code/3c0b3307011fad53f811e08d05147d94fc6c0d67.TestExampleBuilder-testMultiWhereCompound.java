@Test public void testMultiWhereCompound(){
  SqlSession sqlSession=MybatisHelper.getSqlSession();
  try {
    CountryMapper mapper=sqlSession.getMapper(CountryMapper.class);
    Example example=Example.builder(Country.class).selectDistinct().where(Sqls.custom().andEqualTo("countryname","China").andEqualTo("id",35)).orWhere(Sqls.custom().andBetween("countryname",'C','H').andNotLike("countryname","Co%")).andWhere(Sqls.custom().andLessThan("id","100").orGreaterThan("id","55")).orWhere(Sqls.custom().andEqualTo("countryname","Cook Is.")).orderByAsc("id","countryname").orderByDesc("countrycode").forUpdate().build();
    List<Country> countries=mapper.selectByExample(example);
    Assert.assertEquals(35,countries.size());
  }
  finally {
    sqlSession.close();
  }
}
