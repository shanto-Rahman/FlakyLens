@Test public void test_builder(){
  ImmutableMarketData test=ImmutableMarketData.builder(VAL_DATE.plusDays(1)).valuationDate(VAL_DATE).addValue(ID1,"123").addValueUnsafe(ID2,"124").addValueMap(ImmutableMap.of(ID3,"201")).addTimeSeries(ID4,TIME_SERIES).build();
  assertThat(test.getValuationDate()).isEqualTo(VAL_DATE);
  assertThat(test.getValues().get(ID1)).isEqualTo("123");
  assertThat(test.getValues().get(ID2)).isEqualTo("124");
  assertThat(test.getIds()).containsExactly(ID1,ID2,ID3);
  assertThat(test.getTimeSeries().get(ID4)).isEqualTo(TIME_SERIES);
}
