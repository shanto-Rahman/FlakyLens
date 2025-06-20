@Test public void test1(){
assertThat(kv,containsString("ABCDEFGHIJ\n"));
assertThat(kv,containsString("KLMNOPQRST\n"));
assertThat(kv,containsString("UVWXYZ\n"));
assertThat(table,containsString("|OPTIONS|"));
assertThat(table,containsString("|KEY-3"));
}