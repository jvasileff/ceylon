abstract class Abstract() {
    shared formal String name;
}

class Concrete() extends Abstract() {
    name = "Trompon";
    print(name);
}

@error class Broken() extends Abstract() {
    void method() {
        @error name = "Trompon";
    }
}

class IndirectlyBroken() extends Concrete() {
    @error name = "Trompon";
}

class BadlyTyped() extends Abstract() {
    @error name = 1;
}

class BadlyUsed() extends Abstract() {
    @error print(name);
    name = "Tompon";
}

class BadlyDuped() extends Abstract() {
    name = "Gavin";
    @error name = "Tako";
}

class ReallyBadlyDuped() extends Abstract() {
    @error name = "Gavin";
    shared actual String name = "Tako";
}

class OK() extends Abstract() {
    name = "Trompon";
    print(name);
    value x = 0.0;
    shared String getName() {
        return name;
    }
}

abstract class AlsoAbstract() {
    shared formal variable String x;
    shared default String y = "";
}

class AlsoBroken() extends AlsoAbstract() {
    @error x = "hello";
    @error y = "goodbye";
}

Float sq(Float x) {
    return x*x;
}

abstract class OtherAbstract() {
    shared formal Float sqr(Float x);
}

class ReallyIndirectlyBroken() extends OtherConcrete() {
    @error sqr = sq;
}

class AlsoReallyIndirectlyBroken() extends OtherConcrete() {
    @error shared actual Float sqr(Float x) { return x**2; }
}

class OtherConcrete() extends OtherAbstract() {
    sqr = sq;
    sqr(1.0);
}

class OtherBadlyTyped() extends OtherAbstract() {
    @error sqr = print;
}

class OtherBadlyUsed() extends OtherAbstract() {
    @error sqr(2.0);
    sqr = sq;
}

class OtherBadlyDuped() extends OtherAbstract() {
	sqr = sq;
    @error sqr = sq;
}

