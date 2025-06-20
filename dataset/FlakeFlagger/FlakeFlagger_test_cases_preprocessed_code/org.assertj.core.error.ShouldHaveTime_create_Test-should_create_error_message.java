@Test public void should_create_error_message() throws ParseException {
assertEquals("[Test] \nExpecting\n <2011-01-01T05:01:00>\nto have time:\n <123L>\nbut was:\n <" + date.getTime() + "L>",message);
}