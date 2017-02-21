package com.redhat.ceylon.compiler.java.runtime.metamodel.decl;

import java.lang.reflect.AnnotatedElement;
import java.util.ArrayList;
import java.util.List;

import ceylon.language.Anything;
import ceylon.language.DeprecationAnnotation$annotation$;
import ceylon.language.Iterator;
import ceylon.language.Sequential;
import ceylon.language.SharedAnnotation$annotation$;
import ceylon.language.ThrownExceptionAnnotation$annotation$;
import ceylon.language.empty_;
import ceylon.language.finished_;
import ceylon.language.meta.declaration.CallableConstructorDeclaration;
import ceylon.language.meta.declaration.CallableConstructorDeclaration$impl;
import ceylon.language.meta.declaration.ClassDeclaration;
import ceylon.language.meta.declaration.FunctionOrValueDeclaration;
import ceylon.language.meta.declaration.FunctionalDeclaration$impl;
import ceylon.language.meta.declaration.Module;
import ceylon.language.meta.declaration.OpenType;
import ceylon.language.meta.declaration.Package;
import ceylon.language.meta.model.CallableConstructor;
import ceylon.language.meta.model.MemberClassCallableConstructor;
import ceylon.language.meta.model.Type;
import ceylon.language.meta.model.TypeApplicationException;

import com.redhat.ceylon.compiler.java.Util;
import com.redhat.ceylon.compiler.java.metadata.Ceylon;
import com.redhat.ceylon.compiler.java.metadata.Defaulted;
import com.redhat.ceylon.compiler.java.metadata.Ignore;
import com.redhat.ceylon.compiler.java.metadata.Name;
import com.redhat.ceylon.compiler.java.metadata.Sequenced;
import com.redhat.ceylon.common.NonNull;
import com.redhat.ceylon.compiler.java.metadata.TypeInfo;
import com.redhat.ceylon.compiler.java.metadata.TypeParameter;
import com.redhat.ceylon.compiler.java.metadata.TypeParameters;
import com.redhat.ceylon.compiler.java.metadata.Variance;
import com.redhat.ceylon.compiler.java.runtime.metamodel.AnnotationBearing;
import com.redhat.ceylon.compiler.java.runtime.metamodel.FunctionalUtil;
import com.redhat.ceylon.compiler.java.runtime.metamodel.Metamodel;
import com.redhat.ceylon.compiler.java.runtime.metamodel.meta.FunctionImpl;
import com.redhat.ceylon.compiler.java.runtime.model.TypeDescriptor;
import com.redhat.ceylon.compiler.java.runtime.model.TypeDescriptor.Nothing;
import com.redhat.ceylon.model.typechecker.model.Class;
import com.redhat.ceylon.model.typechecker.model.Functional;

@Ceylon(major = 8)
@com.redhat.ceylon.compiler.java.metadata.Class
public class ClassWithInitializerDeclarationConstructor
        extends FunctionOrValueDeclarationImpl
        implements CallableConstructorDeclaration, 
            ceylon.language.meta.declaration.FunctionalDeclaration, 
            AnnotationBearing {
    
    @Ignore
    public static final TypeDescriptor $TypeDescriptor$ = TypeDescriptor.klass(ClassWithInitializerDeclarationConstructor.class);
    
    //final Constructor constructor;
    private Sequential<FunctionOrValueDeclaration> parameterList;
    private Sequential<? extends ceylon.language.meta.declaration.TypeParameter> typeParameters;
    
    public ClassWithInitializerDeclarationConstructor(Class clazz) {
        super(clazz);
        List<com.redhat.ceylon.model.typechecker.model.TypeParameter> typeParameters = clazz.getTypeParameters();
        ceylon.language.meta.declaration.TypeParameter[] typeParametersArray = new ceylon.language.meta.declaration.TypeParameter[typeParameters.size()];
        int i=0;
        for(com.redhat.ceylon.model.typechecker.model.TypeParameter tp : typeParameters){
            typeParametersArray[i++] = new com.redhat.ceylon.compiler.java.runtime.metamodel.decl.TypeParameterImpl(tp);
        }
        this.typeParameters = Util.sequentialWrapper(ceylon.language.meta.declaration.TypeParameter.$TypeDescriptor$, typeParametersArray);
        this.parameterList = FunctionalUtil.getParameters(clazz);
    }
    
    @Override
    public boolean getAnnotation() {
        return false;
    }
    
    @Override
    public boolean getAbstract() {
        return false;
    }
    
    @Override
    public boolean getShared() {
        return true;
    }

    @Override
    public FunctionOrValueDeclaration getParameterDeclaration(String name) {
        return FunctionalUtil.getParameterDeclaration(this.parameterList, name);
    }

    @Override
    @TypeInfo("ceylon.language::Sequential<ceylon.language.meta.declaration::FunctionOrValueDeclaration>")
    public Sequential<? extends FunctionOrValueDeclaration> getParameterDeclarations() {
        return this.parameterList;
    }

    @Override
    @TypeInfo("ceylon.language::Sequential<Annotation>")
    @TypeParameters(@TypeParameter(value = "Annotation", satisfies = "ceylon.language::Annotation"))
    public <Annotation extends java.lang.annotation.Annotation> Sequential<? extends Annotation> annotations(@Ignore TypeDescriptor $reifiedAnnotation) {
        return Metamodel.annotations($reifiedAnnotation, this);
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getQualifiedName() {
        return ((Class)declaration).getQualifiedNameString();
    }

    @Override
    public OpenType getOpenType() {
        return Metamodel.getMetamodel(((Class)declaration).getType());
    }

    @Override
    public Module getContainingModule() {
        return getContainer().getContainingModule();
    }

    @Override
    public Package getContainingPackage() {
        return getContainer().getContainingPackage();
    }

    @Override
    public boolean getToplevel() {
        return false;
    }

    @Override
    public ClassDeclaration getContainer() {
        return (ClassDeclaration)Metamodel.getOrCreateMetamodel((Class)declaration);
    }

    @Override
    @Ignore
    public java.lang.annotation.Annotation[] $getJavaAnnotations$() {
        ArrayList<java.lang.annotation.Annotation> result = new ArrayList<java.lang.annotation.Annotation>(3);
        java.lang.annotation.Annotation[] l = Metamodel.getJavaClass((Class)declaration).getAnnotations();
        for (java.lang.annotation.Annotation a : l) {
            if (a instanceof SharedAnnotation$annotation$
                    || a instanceof DeprecationAnnotation$annotation$
                    || a instanceof ceylon.language.ThrownExceptionAnnotation$annotations$) {
                result.add(a);
            }
        }
        return result.toArray(new java.lang.annotation.Annotation[result.size()]);
    }
    
    @Override
    @Ignore
    public boolean $isAnnotated$(java.lang.Class<? extends java.lang.annotation.Annotation> annotationType) {
        if (annotationType == SharedAnnotation$annotation$.class
                || annotationType == DeprecationAnnotation$annotation$.class
                || annotationType == ceylon.language.ThrownExceptionAnnotation$annotations$.class) {
            final AnnotatedElement element = Metamodel.getJavaClass((Class)declaration);
            return element != null ? element.isAnnotationPresent(annotationType) : false;
        } else {
            return false;
        }
    }
    
    @Override
    public <AnnotationType extends java.lang.annotation.Annotation> boolean annotated(TypeDescriptor reifed$AnnotationType) {
        return Metamodel.isAnnotated(reifed$AnnotationType, this);
    }

    @Override
    @Ignore
    public TypeDescriptor $getType$() {
        return $TypeDescriptor$;
    }
    
    @Override
    public String toString() {
        return "new "+getQualifiedName();
    }
    
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other instanceof ClassWithInitializerDeclarationConstructor) {
            return getContainer().equals(((ClassWithInitializerDeclarationConstructor)other).getContainer())
                    && getName().equals(((ClassWithInitializerDeclarationConstructor)other).getName());
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        return getContainer().hashCode() ^ getName().hashCode();
    }

    @Ignore
    @Override
    public CallableConstructorDeclaration$impl $ceylon$language$meta$declaration$CallableConstructorDeclaration$impl() {
        return null;
    }
    
    @Ignore
    @Override
    public FunctionalDeclaration$impl $ceylon$language$meta$declaration$FunctionalDeclaration$impl() {
        return null;
    }

    @Override
    public Object invoke(Sequential<? extends Type<? extends Object>> typeArguments) {
        return invoke(typeArguments, empty_.get_());
    }

    @Override
    @NonNull
    public Object invoke(Sequential<? extends Type<? extends Object>> typeArguments,
            Sequential<? extends Object> arguments) {
        return apply(Anything.$TypeDescriptor$, TypeDescriptor.NothingType, typeArguments).apply(arguments);
    }
    

    @Override
    public Object memberInvoke(Object containerInstance,
            Sequential<? extends Type<? extends Object>> typeArguments) {
        return memberInvoke(containerInstance, typeArguments, empty_.get_());
    }

    @Override
    @NonNull
    public Object memberInvoke(Object containerInstance,
            Sequential<? extends Type<? extends Object>> typeArguments,
            Sequential<? extends Object> arguments) {
        ceylon.language.meta.model.Type<?> containerType = Metamodel.getAppliedMetamodel(Metamodel.getTypeDescriptor(containerInstance));
        return memberApply(Nothing.NothingType, ceylon.language.Object.$TypeDescriptor$, Nothing.NothingType, 
                containerType, typeArguments).bind(containerInstance).apply(arguments);
    }

    @Override
    public <Result, Arguments extends Sequential<? extends Object>> CallableConstructor<Result, Arguments> apply(
            TypeDescriptor $reified$Result, TypeDescriptor $reified$Arguments) {
        return apply($reified$Result, $reified$Arguments, (Sequential)empty_.get_());
    }
    
    @Override
    public <Result, Arguments extends Sequential<? extends Object>> CallableConstructor<Result, Arguments> apply(
            TypeDescriptor $reified$Result, TypeDescriptor $reified$Arguments,
            Sequential<? extends Type<? extends Object>> typeArguments) {
        // apply the given type arguments to the containing class
        ClassDeclaration clsDecl = getContainer();
        ceylon.language.meta.model.Class<? extends Result, ?> cls 
                = clsDecl.<Result, Sequential<? extends java.lang.Object>>classApply(
                        $reified$Result, Nothing.NothingType, typeArguments);
        // then get the constructor from that
        return Util.assertExists((CallableConstructor)cls.<Arguments>getDeclaredConstructor($reified$Arguments, getName()));
    }
    
    @Override
    @Ignore
    public <Container, Result, Arguments extends Sequential<? extends Object>> MemberClassCallableConstructor<Container, Result, Arguments> memberApply(
            TypeDescriptor $reified$Container, TypeDescriptor $reified$Result, TypeDescriptor $reified$Arguments,
            Type<? extends Object> containerType) {
        return memberApply($reified$Container, $reified$Result, $reified$Arguments, containerType, (Sequential)empty_.get_());
    }
    
    @Override
    public <Container, Result, Arguments extends Sequential<? extends Object>> MemberClassCallableConstructor<Container, Result, Arguments> memberApply(
            TypeDescriptor $reified$Container, TypeDescriptor $reified$Result, TypeDescriptor $reified$Arguments,
            Type<? extends Object> containerType,
            Sequential<? extends Type<? extends Object>> typeArguments) {
        // apply the given type arguments to the containing class
        ceylon.language.meta.model.MemberClass<? super Container, ? extends Result, ?> cls 
                = getContainer().<Container, Result, Sequential<? extends Object>>memberClassApply(
                        $reified$Container, $reified$Result, Nothing.NothingType, containerType, typeArguments);
        // then get the constructor from that
        return Util.assertExists((MemberClassCallableConstructor)cls.<Arguments>getDeclaredConstructor($reified$Arguments, getName()));
    }
    
    @Override
    public boolean getDefaultConstructor() {
        return getName().isEmpty();
    }
    
    /////////////////////////////////////////
   

    @Override
    @TypeInfo("ceylon.language::Sequential<ceylon.language.meta.declaration::TypeParameter>")
    public Sequential<? extends ceylon.language.meta.declaration.TypeParameter> getTypeParameterDeclarations() {
        return typeParameters;
    }

    @Override
    @TypeInfo("ceylon.language.meta.declaration::TypeParameter|ceylon.language::Null")
    public ceylon.language.meta.declaration.TypeParameter getTypeParameterDeclaration(@Name("name") String name) {
        Iterator<? extends ceylon.language.meta.declaration.TypeParameter> iterator = typeParameters.iterator();
        Object it;
        while((it = iterator.next()) != finished_.get_()){
            ceylon.language.meta.declaration.TypeParameter tp = (ceylon.language.meta.declaration.TypeParameter) it;
            if(tp.getName().equals(name))
                return tp;
        }
        return null;
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Ignore
    @Override
    public ceylon.language.Sequential<? extends ceylon.language.meta.model.Type<?>> invoke$typeArguments(){
        return (ceylon.language.Sequential<? extends ceylon.language.meta.model.Type<?>>)(Sequential)empty_.get_();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Ignore
    @Override
    public java.lang.Object invoke(){
        return invoke((ceylon.language.Sequential<? extends ceylon.language.meta.model.Type<?>>)(Sequential)empty_.get_());
    }


    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Ignore
    @Override
    public ceylon.language.Sequential<? extends ceylon.language.meta.model.Type<?>> 
        memberInvoke$typeArguments(java.lang.Object container){
        return (ceylon.language.Sequential<? extends ceylon.language.meta.model.Type<?>>)(Sequential)empty_.get_();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Ignore
    @Override
    public java.lang.Object memberInvoke(java.lang.Object container){
        return memberInvoke(container, (ceylon.language.Sequential<? extends ceylon.language.meta.model.Type<?>>)(Sequential)empty_.get_());
    }

    
    @Override
    public Sequential<? extends ceylon.language.meta.model.Type<?>> 
            staticInvoke$typeArguments(ceylon.language.meta.model.Type<? extends Object> containerType) {
        return (Sequential)empty_.get_();
    }
    
    @Override
    public java.lang.Object staticInvoke(
            @Name("containerType") 
            ceylon.language.meta.model.Type<? extends Object> containerType){
        return staticInvoke(containerType, (Sequential)empty_.get_());
    }
    
    public ceylon.language.Sequential<?> 
    staticInvoke$arguments(ceylon.language.meta.model.Type<? extends Object> containerType,
            ceylon.language.Sequential<? extends ceylon.language.meta.model.Type<?>> typeArguments) {
        return (Sequential)empty_.get_();
    }
    
    @Override
    public java.lang.Object staticInvoke(
            @Name("containerType") 
            ceylon.language.meta.model.Type<? extends Object> containerType,
            @Name("typeArguments") @Defaulted 
            @TypeInfo("ceylon.language::Sequential<ceylon.language.meta.model::Type<ceylon.language::Anything>>")
            ceylon.language.Sequential<? extends ceylon.language.meta.model.Type<?>> typeArguments){
        return staticInvoke(containerType, typeArguments, empty_.get_());
    }
    
    @SuppressWarnings("unchecked")
    @TypeInfo("ceylon.language::Anything")
    @Override
    public java.lang.Object staticInvoke(
            @Name("containerType") 
            ceylon.language.meta.model.Type<? extends Object> containerType,
            @Name("typeArguments") @Defaulted 
            @TypeInfo("ceylon.language::Sequential<ceylon.language.meta.model::Type<ceylon.language::Anything>>")
            ceylon.language.Sequential<? extends ceylon.language.meta.model.Type<?>> typeArguments,
            @Name("arguments") @Sequenced @TypeInfo("ceylon.language::Sequential<ceylon.language::Anything>") 
            ceylon.language.Sequential<?> arguments){
        throw new TypeApplicationException("");
    }
    
    @Override
    public <Return extends Object, Arguments extends Sequential<? extends Object>> ceylon.language.meta.model.Function<Return, Arguments> staticApply(
            @Ignore TypeDescriptor $reifiedReturn,
            @Ignore TypeDescriptor $reifiedArguments,
            @Name("containerType") ceylon.language.meta.model.Type<? extends Object> containerType) {
        return staticApply($reifiedReturn, $reifiedArguments, containerType, (Sequential)empty_.get_());
    }
    
    @Override
    public <Return extends Object, Arguments extends Sequential<? extends Object>> ceylon.language.meta.model.Function<Return, Arguments> staticApply(
            @Ignore TypeDescriptor $reifiedReturn,
            @Ignore TypeDescriptor $reifiedArguments,
            @Name("containerType") ceylon.language.meta.model.Type<? extends Object> containerType,
            @Name("typeArguments") @Sequenced Sequential<? extends ceylon.language.meta.model.Type<?>> typeArguments) {
        throw new ceylon.language.meta.model.TypeApplicationException("Not implemented");
        /*if(!getStatic())
            throw new ceylon.language.meta.model.TypeApplicationException(
                    "Cannot apply a " 
            + (getToplevel() ? "toplevel" : "member") 
            + " declaration to a container type: use " 
            + (getToplevel() ? "apply" : "memberApply"));
        List<com.redhat.ceylon.model.typechecker.model.Type> producedTypes = Metamodel.getProducedTypes(typeArguments);
        Metamodel.checkTypeArguments(null, declaration, producedTypes);
        com.redhat.ceylon.model.typechecker.model.Reference appliedFunction = declaration.appliedReference(null, producedTypes);
        TypeDescriptor reifiedType = Metamodel.getTypeDescriptorForFunction(appliedFunction);
        TypeDescriptor reifiedArguments = Metamodel.getTypeDescriptorForArguments(declaration.getUnit(), (Functional) declaration, appliedFunction);

        Metamodel.checkReifiedTypeArgument("apply", "Function<$1,$2>", Variance.OUT, 
                declaration.getUnit().getCallableReturnType(appliedFunction.getFullType()), $reifiedReturn, 
                Variance.IN, Metamodel.getProducedTypeForArguments(declaration.getUnit(), (Functional)declaration, appliedFunction), $reifiedArguments);
        return new FunctionImpl<Return,Arguments>(reifiedType, reifiedArguments, appliedFunction, this, containerType, null);*/
    }
}
