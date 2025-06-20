@Test public void itDefersTripleLayer(){
  setupResourceLocator();
  context.put("a_val",DeferredValue.instance("a"));
  context.put("b_val","b");
  context.put("c_val","c");
  String result=interpreter.render("{% import 'import-tree-c.jinja' as c %}{{ c|dictsort(false, 'key') }}");
  assertThat(interpreter.render("{{ c.b.a.foo_a }}")).isEqualTo("{{ c.b.a.foo_a }}");
  assertThat(interpreter.render("{{ c.b.foo_b }}")).isEqualTo("{{ c.b.foo_b }}");
  assertThat(interpreter.render("{{ c.foo_c }}")).isEqualTo("{{ c.foo_c }}");
  removeDeferredContextKeys();
  context.put("a_val","a");
  assertThat(interpreter.render(result).trim()).isEqualTo(interpreter.render("{% import 'import-tree-c.jinja' as c %}{{ c|dictsort(false, 'key') }}"));
}
