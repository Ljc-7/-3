项目名称：Android CameraX 实验（CameraXApp）

实验课程：Android 开发 / Kotlin 编程
学生姓名：（填写你的姓名）
学号：（填写你的学号）
实验日期：2026年5月15日

项目简介

本项目是 Android 开发课程的实验项目，基于 Jetpack CameraX 库构建一个完整的相机应用。实现了以下功能：

实时相机预览（Preview）

拍照并保存图片（ImageCapture）

录制视频并保存（VideoCapture）

扩展功能：实时图像分析（ImageAnalysis），计算每一帧的平均亮度并显示

通过本项目，掌握了 CameraX 的基本用法、运行时权限处理、生命周期绑定以及简单的图像分析技术。

环境要求

Android Studio Hedgehog 或更新版本

编译 SDK：API 34

最低支持：API 21（Android 5.0）

真机测试（需要后置摄像头及麦克风）

Kotlin 版本：1.9+

CameraX 版本：1.5.0-alpha06

主要依赖（build.gradle）

dependencies {
implementation 'androidx.core:core-ktx:1.12.0'
implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.7.0'
implementation 'androidx.activity:activity-compose:1.8.0'

def camerax_version = "1.5.0-alpha06"
implementation "androidx.camera:camera-core:
c
a
m
e
r
a
x
v
e
r
s
i
o
n
"
i
m
p
l
e
m
e
n
t
a
t
i
o
n
"
a
n
d
r
o
i
d
x
.
c
a
m
e
r
a
:
c
a
m
e
r
a
−
c
a
m
e
r
a
2
:
camerax 
v
​
 ersion"implementation"androidx.camera:camera−camera2:camerax_version"
implementation "androidx.camera:camera-lifecycle:
c
a
m
e
r
a
x
v
e
r
s
i
o
n
"
i
m
p
l
e
m
e
n
t
a
t
i
o
n
"
a
n
d
r
o
i
d
x
.
c
a
m
e
r
a
:
c
a
m
e
r
a
−
v
i
d
e
o
:
camerax 
v
​
 ersion"implementation"androidx.camera:camera−video:camerax_version"
implementation "androidx.camera:camera-view:
c
a
m
e
r
a
x
v
e
r
s
i
o
n
"
/
/
可选：图像分析扩展
i
m
p
l
e
m
e
n
t
a
t
i
o
n
"
a
n
d
r
o
i
d
x
.
c
a
m
e
r
a
:
c
a
m
e
r
a
−
m
l
k
i
t
−
v
i
s
i
o
n
:
camerax 
v
​
 ersion"//可选：图像分析扩展implementation"androidx.camera:camera−mlkit−vision:camerax_version"
}

功能说明

相机预览

使用 PreviewView 显示摄像头实时画面。

自动选择后置摄像头，支持设备旋转适配。

拍照

点击“拍照”按钮，保存图片到应用的 Pictures 目录。

拍照成功后显示 Toast 提示图片保存路径。

录像

点击“开始录像”按钮开始录制视频（包含音频）。

点击“停止录像”按钮结束录制，视频保存到 Movies 目录。

需要授予录音权限。

图像分析（扩展）

实时计算每一帧图像的平均亮度值（0~255）。

在界面底部 TextView 中显示当前亮度。

分析器在子线程运行，通过 Handler 更新 UI。

使用步骤

克隆仓库：
git clone https://github.com/你的用户名/CameraXApp.git

使用 Android Studio 打开项目。

等待 Gradle 同步完成。

连接一台具有摄像头和麦克风的 Android 真机（API 21+）。

运行应用，授予相机和录音权限。

预览画面出现后，尝试拍照、录像，观察保存结果。

如果启用图像分析，查看亮度数值的变化。

截图

（以下位置可放置实际截图）

截图1：应用主界面（预览画面 + 按钮）

截图2：拍照成功后的 Toast 提示

截图3：录像开始/停止状态

截图4：图像分析亮度显示（扩展实验）

代码结构

app/src/main/java/com/example/cameraXApp/
├── MainActivity.kt # 主界面，CameraX 用例绑定及按钮事件
└── (可选) BrightnessAnalyzer.kt # 图像分析器实现

app/src/main/res/layout/
└── activity_main.xml # 布局文件（PreviewView + 按钮 + TextView）

app/src/main/AndroidManifest.xml # 权限声明

关键代码片段

绑定预览、拍照、录像用例：
val cameraProvider = ProcessCameraProvider.getInstance(this).get()
val preview = Preview.Builder().build()
val imageCapture = ImageCapture.Builder().build()
val videoCapture = VideoCapture.Builder().build()
val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
cameraProvider.bindToLifecycle(this, cameraSelector, preview, imageCapture, videoCapture)

拍照保存：
imageCapture.takePicture(
Executors.newSingleThreadExecutor(),
object : ImageCapture.OnImageSavedCallback {
override fun onImageSaved(output: ImageCapture.OutputFileResults) {
Toast.makeText(this@MainActivity, "图片已保存: ${output.savedUri}", Toast.LENGTH_SHORT).show()
}
override fun onError(exception: ImageCaptureException) {
Log.e(TAG, "拍照失败", exception)
}
}
)

录像启动与停止：
val recording = videoCapture.output
recording.startRecording(file, executor, callback)
recording.stop()

图像分析器示例：
class BrightnessAnalyzer : ImageAnalysis.Analyzer {
override fun analyze(imageProxy: ImageProxy) {
val buffer = imageProxy.planes[0].buffer
// 计算平均亮度...
imageProxy.close()
}
}

遇到的问题及解决方法

录像无声：未添加 RECORD_AUDIO 权限。在 AndroidManifest.xml 和运行时权限中添加后解决。

图片保存失败（Android 10+）：由于分区存储限制，改用 getExternalFilesDir(Environment.DIRECTORY_PICTURES) 作为保存路径，无需申请存储权限。

图像分析 UI 更新崩溃：分析器在子线程运行，使用 Handler(Looper.getMainLooper()).post { ... } 更新 TextView。

参考教程

CameraX 官方文档：https://developer.android.com/training/camerax

CameraX 入门指南：https://developer.android.com/camera/camerax/getting-started

Kotlin 语言参考：https://kotlinlang.org/

仓库地址

GitHub: https://github.com/你的用户名/CameraXApp
