import org.eclipse.ceylon.launcher{
    Bootstrap
}
import ceylon.language.meta.model {
    Class
}
import ceylon.modules.api.runtime {
    AbstractRuntime
}

import org.eclipse.ceylon.cmr.api {
    ModuleInfo
}
import org.eclipse.ceylon.common {
    Versions
}
import org.eclipse.ceylon.compiler.java.codegen {
    Operators
}
import org.eclipse.ceylon.compiler.js.util {
    TypeUtils
}
import org.eclipse.ceylon.compiler.typechecker.tree {
    TreeUtil
}
import org.eclipse.ceylon.model.typechecker.model {
    ModelClass=Class
}
import ceylon.language.meta {
    modules
}
"Run the module `compat`."
shared void test(String expectedRuntime = "1.2.1") {
    print("Compiled with ``Versions.\iCEYLON_VERSION`` according to org.eclipse.ceylon.common::Versions");
    assert("1.2.99" == Versions.\iCEYLON_VERSION_NUMBER);
    print("Running on ``language.version`` (``language.versionName``) according to language.version");
    assert(expectedRuntime == language.version);
    
    // Check module literals of direct dependencies
    assert("module compiled1299/1.0.0" == `module`.string);
    assert("module ceylon.language/``expectedRuntime``" == `module ceylon.language`.string);
    //XXX see ceylon-compiler#2428 print("\`module ceylon.runtime\` is `` `module ceylon.runtime` ``");
    assert("module org.eclipse.ceylon.common/``expectedRuntime``" == `module org.eclipse.ceylon.common`.string);
    //XXX see ceylon-compiler#2428print(`module org.eclipse.ceylon.typechecker`); 
    //XXX WTF print(`module "org.eclipse.ceylon.module-resolver"`); 
    assert("module org.eclipse.ceylon.compiler.java/``expectedRuntime``" == `module org.eclipse.ceylon.compiler.java`.string);
    assert("module org.eclipse.ceylon.compiler.js/``expectedRuntime``" == `module org.eclipse.ceylon.compiler.js`.string);
    //XXX see ceylon-compiler#2428 print(`module org.eclipse.ceylon.model`); 
    //XXX see ceylon-compiler#2428print("\`module ceylon.bootstrap\` is `` `module ceylon.bootstrap` ``"); 
    
    print("\`module\`.dependencies");
    for (imp in `module`.dependencies) {
        print("  ``imp``");
        // All our dependencies should be version 1.2.1 as runtime 
        assert(expectedRuntime == imp.version);
    }
    // check we can list all the loaded modules
    print("modules.list: ");
    for (mod in modules.list) {
        print("  ``mod``");
    }
    
    print("Now test metamodels of distribution modules");
    Class<String> lang = `String`;
    assert(lang.declaration.containingModule == `module ceylon.language`);
    Class<ModuleInfo> cmr = `ModuleInfo`;
    print("  ``cmr``");
    //print(cmr.declaration.containingModule);
    Class<ModelClass> model = `ModelClass`;
    print("  ``model``");
    Class<Operators> jvm = `Operators`;
    print("  ``jvm``");
    assert(jvm.declaration.containingModule == `module org.eclipse.ceylon.compiler.java`);
    Class<TypeUtils> js = `TypeUtils`;
    print("  ``js``");
    assert(js.declaration.containingModule == `module org.eclipse.ceylon.compiler.js`);
    Class<TreeUtil> tc = `TreeUtil`;
    print("  ``tc``");
    Class<Versions> common = `Versions`;
    print("  ``common``");
    Class<AbstractRuntime> runtime = `AbstractRuntime`;
    print("  ``runtime``");
    Class<Bootstrap> bootstrap = `Bootstrap`;
    print("  ``bootstrap``");
}

shared void runOn120() {
    test("1.2.0");
}

shared void runOnLatest() {
    assert(exists version = process.arguments[0]);
    test(version);
}