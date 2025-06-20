@Test public void should_create_AssertionError_with_message_differentiating_expected_and_actual_persons(){
assertThat(error.getMessage()).isEqualTo("[my test] \nExpecting:\n <\"Person[name=Jake] (Person@" + toHexString(actual.hashCode()) + ")\">\nto be equal to:\n <\"Person[name=Jake] (Person@"+ toHexString(expected.hashCode())+ ")\">\nbut was not.");
}