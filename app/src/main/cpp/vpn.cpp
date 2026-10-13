#include <jni.h>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_siddhartha_vpn_MainActivity_cppMessage(
        JNIEnv* env,
        jobject) {

    return env->NewStringUTF(
        "C++ VPN library is working!"
    );
}
