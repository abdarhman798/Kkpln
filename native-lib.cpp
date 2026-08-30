#include <jni.h>
#include <string>

extern "C" JNIEXPORT void JNICALL
Java_com_abboud_executor_MainActivity_executeScriptNative(
        JNIEnv* env,
        jobject,
        jstring script) {
    
    const char *script_c = env->GetStringUTFChars(script, nullptr);
    
    env->ReleaseStringUTFChars(script, script_c);
}
