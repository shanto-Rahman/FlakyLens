@Test public void should_fail_since_actual_is_not_zero_in_hex_representation(){
assertEquals("expected:<0x0[0]> but was:<0x0[2]>",e.getMessage());
}