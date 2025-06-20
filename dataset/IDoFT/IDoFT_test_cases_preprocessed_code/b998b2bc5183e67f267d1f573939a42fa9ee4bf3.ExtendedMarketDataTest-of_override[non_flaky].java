@Test public void of_override(){
assertThat(test.getId()).isEqualTo(ID1);
assertThat(test.getValue()).isEqualTo(VAL3);
assertThat(test.getValuationDate()).isEqualTo(VAL_DATE);
assertThat(test.containsValue(ID1)).isEqualTo(true);
assertThat(test.containsValue(ID2)).isEqualTo(true);
assertThat(test.containsValue(ID3)).isEqualTo(false);
assertThat(test.getValue(ID1)).isEqualTo(VAL3);
assertThat(test.getValue(ID2)).isEqualTo(VAL2);
assertThat(test.findValue(ID1)).isEqualTo(Optional.of(VAL3));
assertThat(test.findValue(ID2)).isEqualTo(Optional.of(VAL2));
assertThat(test.findValue(ID3)).isEqualTo(Optional.empty());
assertThat(test.getIds()).containsExactlyInAnyOrder(ID1,ID2);
assertThat(test.getTimeSeries(ID4)).isEqualTo(TIME_SERIES);
}