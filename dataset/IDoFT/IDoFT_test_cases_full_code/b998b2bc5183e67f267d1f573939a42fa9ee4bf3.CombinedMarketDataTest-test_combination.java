@Test public void test_combination(){
  CombinedMarketData test=new CombinedMarketData(BASE_DATA1,BASE_DATA2);
  assertThat(test.getValuationDate()).isEqualTo(VAL_DATE);
  assertThat(test.containsValue(ID1)).isEqualTo(true);
  assertThat(test.containsValue(ID2)).isEqualTo(true);
  assertThat(test.containsValue(ID3)).isEqualTo(true);
  assertThat(test.containsValue(ID5)).isEqualTo(false);
  assertThat(test.getValue(ID1)).isEqualTo(VAL1);
  assertThat(test.getValue(ID2)).isEqualTo(VAL2);
  assertThat(test.getValue(ID3)).isEqualTo(VAL3);
  assertThatExceptionOfType(MarketDataNotFoundException.class).isThrownBy(() -> test.getValue(ID5));
  assertThat(test.findValue(ID1)).isEqualTo(Optional.of(VAL1));
  assertThat(test.findValue(ID2)).isEqualTo(Optional.of(VAL2));
  assertThat(test.findValue(ID3)).isEqualTo(Optional.of(VAL3));
  assertThat(test.findValue(ID5)).isEqualTo(Optional.empty());
  assertThat(test.getIds()).containsExactly(ID1,ID2,ID3);
  assertThat(test.findIds(ID1.getMarketDataName())).isEqualTo(ImmutableSet.of(ID1));
  assertThat(test.findIds(ID3.getMarketDataName())).isEqualTo(ImmutableSet.of(ID3));
  assertThat(test.findIds(ID4.getMarketDataName())).isEqualTo(ImmutableSet.of());
  assertThat(test.getTimeSeries(ID5)).isEqualTo(TIME_SERIES);
  assertThat(test.getTimeSeries(ID6)).isEqualTo(TIME_SERIES);
}
