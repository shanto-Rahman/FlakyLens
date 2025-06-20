@Test public void itDefersTripleLayer(){
assertThat(interpreter.render("{{ c.b.a.foo_a }}")).isEqualTo("{{ c.b.a.foo_a }}");
assertThat(interpreter.render("{{ c.b.foo_b }}")).isEqualTo("{{ c.b.foo_b }}");
assertThat(interpreter.render("{{ c.foo_c }}")).isEqualTo("{{ c.foo_c }}");
assertThat(interpreter.render(result).trim()).isEqualTo(interpreter.render("{% import 'import-tree-c.jinja' as c %}{{ c|dictsort(false, 'key') }}"));
}