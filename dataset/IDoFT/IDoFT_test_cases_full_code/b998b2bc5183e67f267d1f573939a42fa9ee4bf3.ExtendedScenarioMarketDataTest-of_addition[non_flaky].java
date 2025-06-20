@Test public void of_addition(){
  ExtendedScenarioMarketData<String> test=ExtendedScenarioMarketData.of(ID3,VAL3,BASE_DATA);
  assertThat(test.getId()).isEqualTo(ID3);
  assertThat(test.getValue()).isEqualTo(VAL3);
  assertThat(test.getValuationDate()).isEqualTo(MarketDataBox.ofSingleValue(VAL_DATE));
  assertThat(test.containsValue(ID1)).isEqualTo(true);
  assertThat(test.containsValue(ID2)).isEqualTo(true);
  assertThat(test.containsValue(ID3)).isEqualTo(true);
  assertThat(test.containsValue(ID4)).isEqualTo(false);
  assertThat(test.getValue(ID1)).isEqualTo(VAL1);
  assertThat(test.getValue(ID2)).isEqualTo(VAL2);
  assertThat(test.getValue(ID3)).isEqualTo(VAL3);
  assertThatExceptionOfType(MarketDataNotFoundException.class).isThrownBy(() -> test.getValue(ID4));
  assertThat(test.findValue(ID1)).isEqualTo(Optional.of(VAL1));
  assertThat(test.findValue(ID2)).isEqualTo(Optional.of(VAL2));
  assertThat(test.findValue(ID3)).isEqualTo(Optional.of(VAL3));
  assertThat(test.findValue(ID4)).isEqualTo(Optional.empty());
  assertThat(test.getIds()).containsExactlyInAnyOrder(ID1,ID2,ID3);
  assertThat(test.findIds(ID1.getMarketDataName())).isEqualTo(ImmutableSet.of(ID1));
  assertThat(test.findIds(ID3.getMarketDataName())).isEqualTo(ImmutableSet.of(ID3));
  assertThat(test.getTimeSeries(ID4)).isEqualTo(TIME_SERIES);
}
