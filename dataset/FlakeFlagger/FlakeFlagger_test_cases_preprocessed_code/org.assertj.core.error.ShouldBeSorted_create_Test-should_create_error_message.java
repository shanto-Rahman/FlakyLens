@Test public void should_create_error_message(){
assertEquals("[Test] \ngroup is not sorted because element 1:\n <\"c\">\nis not less or equal than element 2:\n <\"a\">\ngroup was:\n <[\"b\", \"c\", \"a\"]>",message);
}