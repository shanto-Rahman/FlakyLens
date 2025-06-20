@Test public void testEquals(){
Assert.assertThat(statistics1,equalTo(statistics1));
Assert.assertThat(statistics1,equalTo(statistics2));
Assert.assertThat(statistics1,not(equalTo(statistics2)));
Assert.assertThat(statistics1.hashCode(),not(equalTo(statistics2.hashCode())));
Assert.assertThat(statistics1,not(equalTo(statistics2)));
Assert.assertThat(statistics1.hashCode(),not(equalTo(statistics2.hashCode())));
Assert.assertThat(statistics1,not(equalTo(statistics2)));
Assert.assertThat(statistics1.hashCode(),not(equalTo(statistics2.hashCode())));
}