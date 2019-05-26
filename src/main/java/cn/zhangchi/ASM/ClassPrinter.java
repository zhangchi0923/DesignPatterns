package cn.zhangchi.ASM;


import aj.org.objectweb.asm.ClassReader;
import aj.org.objectweb.asm.ClassVisitor;
import aj.org.objectweb.asm.FieldVisitor;
import aj.org.objectweb.asm.MethodVisitor;

import java.io.IOException;

import static aj.org.objectweb.asm.Opcodes.ASM4;


public class ClassPrinter extends ClassVisitor {
    public static void main(String[] args) throws IOException {
        ClassPrinter cp = new ClassPrinter();
//        ClassReader cr = new ClassReader("java.lang.Runnable");
        ClassReader cr = new ClassReader(
                ClassPrinter.class.getClassLoader().getResourceAsStream("cn/zhangchi/ASM/T1.class")
        );
        cr.accept(cp,0);
    }



    public ClassPrinter(){
        super(ASM4);
    }

    public void visit(int version,int access,String name,String signature,String supername,String[] interfaces){
        System.out.println(name+" extends "+supername+"{");
    }

    public FieldVisitor visitField(int access,String name,String descriptor,String signature,Object value){
        System.out.println("    "+name);
        return null;
    }

    public MethodVisitor visitMethod(int access,String name,String descriptor,String signature,String[] exceptions){
        System.out.println("    "+name+"()");
        return null;
    }

    public void visitEnd(){
        System.out.println("}");
    }
}
