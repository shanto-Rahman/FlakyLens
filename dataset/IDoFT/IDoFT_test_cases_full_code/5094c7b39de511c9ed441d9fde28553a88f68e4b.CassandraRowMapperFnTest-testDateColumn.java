@Test public void testDateColumn(){
  LocalDate now=LocalDate.now();
  LocalDate epoch=LocalDate.ofEpochDay(0);
  long value=(long)Math.pow(2,31) + ChronoUnit.DAYS.between(epoch,now);
  DateTime expectedDate=new DateTime(now.getYear(),now.getMonthValue(),now.getDayOfMonth(),0,0);
  primeWithType(value,DATE);
  ResultSet resultSet=getResultSet();
  Schema schema=Schema.builder().addNullableField("col",FieldType.DATETIME).build();
  Row expected=Row.withSchema(schema).addValue(expectedDate).build();
  assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}
