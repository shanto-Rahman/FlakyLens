public void testNativeSerialization() throws Exception {
  Node first=new Node("first");
  Node second=new Node("second");
  first.next=second;
  second.next=first;
  String yaml=MAPPER.writeValueAsString(first);
  assertYAML(SIMPLE_YAML_NATIVE,yaml);
}
