package cn.zhangchi.ASM;

import aj.org.objectweb.asm.ClassReader;
import aj.org.objectweb.asm.ClassVisitor;
import aj.org.objectweb.asm.ClassWriter;
import aj.org.objectweb.asm.MethodVisitor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static aj.org.objectweb.asm.Opcodes.ASM4;
import static aj.org.objectweb.asm.Opcodes.INVOKESTATIC;

public class ClassTransformerTest {
    public static void main(String[] args) throws IOException {
        ClassReader cr = new ClassReader(
                ClassPrinter.class.getClassLoader().getResourceAsStream("cn/zhangchi/ASM/Tank.class")
        );

        ClassWriter cw = new ClassWriter(0);
        ClassVisitor cv = new ClassVisitor(ASM4,cw) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
                MethodVisitor mv = super.visitMethod(access,name,descriptor,signature,exceptions);
                return new MethodVisitor(ASM4,mv) {
                    @Override
                    public void visitCode() {
                        visitMethodInsn(INVOKESTATIC,"TimeProxy","before","()V",false);
                        super.visitCode();
                    }
                };
            }
        };

        cr.accept(cv,0);
        byte[] b2 = cw.toByteArray();

        String path = (String)System.getProperties().get("user.dir");
        File f = new File(path+"/cn/zhangchi/temp/");
        f.mkdirs();

        FileOutputStream fos = new FileOutputStream(new File(path+"/cn/zhangchi/temp/Tank_0.class"));
        fos.write(b2);
        fos.flush();
        fos.close();
    }
}
