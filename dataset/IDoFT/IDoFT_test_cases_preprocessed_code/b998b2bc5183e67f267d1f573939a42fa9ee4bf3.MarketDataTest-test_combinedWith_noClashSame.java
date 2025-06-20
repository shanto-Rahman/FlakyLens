@Test public void test_combinedWith_noClashSame(){
assertThat(test.getValue(ID1)).isEqualTo(VAL1);
assertThat(test.getValue(ID2)).isEqualTo(VAL2);
assertThat(test.getIds()).containsExactly(ID1,ID2);
}