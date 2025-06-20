@Test public void should_create_error_message_with_private_static_comparator(){
assertEquals("[Test] \ngroup is not sorted according to 'StaticStringComparator' comparator because element 1:\n <\"c\">\nis not less or equal than element 2:\n <\"a\">\ngroup was:\n <[\"b\", \"c\", \"a\"]>",message);
}