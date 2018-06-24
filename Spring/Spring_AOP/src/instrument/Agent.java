package instrument;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

public class Agent {
    public static void premain(String agentArgs, Instrumentation inst) {
        ClassFileTransformer transformer = new Transformer();
        inst.addTransformer(transformer);
    }
}